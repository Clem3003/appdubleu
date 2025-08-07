import { Component, inject, OnDestroy, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { InputText } from 'primeng/inputtext';
import {LoginManager} from '../login.manager';

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
  private manager = inject(LoginManager);
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
    console.log("onSubmit", this.form.value);
    if (!this.form || this.form.invalid) {
      this.form.markAllAsTouched();
      return;
    }

    // Récupération sécurisée des valeurs (non typée)
    const username = this.form.get('username')?.value;
    const password = this.form.get('password')?.value;

    this.manager.login(username, password).subscribe({
      next: (res) => {
        console.log('Success', res.token); // TODO : Remove this
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
