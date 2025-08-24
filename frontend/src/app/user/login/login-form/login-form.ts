import { Component, inject, OnDestroy, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import {Router, RouterLink} from '@angular/router';
import { InputText } from 'primeng/inputtext';
import {LoginManager} from '../login.manager';
import {NgIf} from '@angular/common';

@Component({
  selector: 'app-login-form',
  imports: [
    ReactiveFormsModule,
    InputText,
    RouterLink,
    NgIf
  ],
  templateUrl: './login-form.html',
  standalone: true
})
export class LoginForm implements OnInit, OnDestroy {
  private readonly fb = inject(FormBuilder);
  protected form!: FormGroup;
  private manager = inject(LoginManager);
  private readonly router = inject(Router);
  protected errorMessage: string | null = null;

  ngOnInit() {
    this.initForm();
    this.form.get('username')?.valueChanges.subscribe(value => {
      if (value !== value.toLowerCase()) {
        this.form.get('username')?.setValue(value.toLowerCase(), { emitEvent: false });
      }
    });
  }

  private initForm(): void {
    this.form = this.fb.group({
      username: new FormControl(null, Validators.required),
      password: new FormControl('', Validators.required),
    });
  }

  onSubmit(): void {
    console.log("onSubmit", this.form.value);
    if (!this.form || this.form.invalid) {
      this.form.markAllAsTouched();
      return;
    }

    const username = this.form.get('username')?.value;
    const password = this.form.get('password')?.value;

    this.manager.login(username, password).subscribe({
      next: (res) => {
        console.log('Login success', res); // plus de token ici
        this.router.navigate(['/dashboard']);
      },
      error: (err) => {
        console.error('Échec de la connexion', err);

        if (err.status === 401) {
          this.errorMessage = "Nom d'utilisateur ou mot de passe incorrect.";
        } else if (err.status === 403) {
          this.errorMessage = "Votre compte est désactivé, contactez votre administrateur.";
        } else {
          this.errorMessage = "Une erreur est survenue, veuillez réessayer plus tard.";
        }
      }
    });
  }

  ngOnDestroy(): void {
    // cleanup si nécessaire
  }
}
