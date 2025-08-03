import { Component, inject, OnDestroy, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { InputText } from 'primeng/inputtext';
import { AuthService } from '../../auth/auth.service';

@Component({
  selector: 'app-login-form',
  imports: [
    ReactiveFormsModule,
    InputText
  ],
  templateUrl: './login-form.html',
  standalone: true
})
export class LoginForm implements OnInit, OnDestroy {
  private readonly fb = inject(FormBuilder);
  protected form!: FormGroup;
  private authService = inject(AuthService);
  private readonly router = inject(Router);

  ngOnInit() {
    this.initForm();
  }

  private initForm(): void {
    this.form = this.fb.group({
      username: new FormControl('', Validators.required),
      password: new FormControl('', Validators.required),
    });
  }

  onSubmit(): void {
    if (!this.form || this.form.invalid) {
      this.form.markAllAsTouched();
      return;
    }

    // Récupération sécurisée des valeurs (non typée)
    const username = this.form.get('username')?.value;
    const password = this.form.get('password')?.value;

    this.authService.login(username, password).subscribe({
      next: (res) => {
        this.authService.saveToken(res.token);
        console.log('Success', res.token);
        this.router.navigate(['/']);
      },
      error: (err) => {
        console.error('Échec de la connexion', err);
      }
    });
  }

  ngOnDestroy(): void {
    // cleanup si nécessaire
  }
}
