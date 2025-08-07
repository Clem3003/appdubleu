import {Component, inject, OnInit} from '@angular/core';
import {FormBuilder, FormControl, FormGroup, FormsModule, ReactiveFormsModule, Validators} from '@angular/forms';
import {Router} from '@angular/router';
import {InputText} from 'primeng/inputtext';
import {RegisterManager} from '../register.manager';
import {RegisterRequest} from '../register.model';
import {ButtonDirective} from "primeng/button";

@Component({
  selector: 'app-register-form',
  imports: [
    FormsModule,
    InputText,
    ReactiveFormsModule,
    ButtonDirective
  ],
  templateUrl: './register-form.html'
})
export class RegisterForm implements OnInit {
  private readonly fb = inject(FormBuilder);
  protected form!: FormGroup;
  private manager = inject(RegisterManager);
  private readonly router = inject(Router);

  ngOnInit() {
    this.initForm();
  }

  private initForm(): void {
    this.form = this.fb.group({
      firstname: new FormControl('', Validators.required),
      lastname: new FormControl('', Validators.required),
      nickname: new FormControl('', Validators.required),
      email: new FormControl('', Validators.required),
      dateOfBirth: new FormControl('', Validators.required),
      password: new FormControl('', Validators.required),
    });
  }

  onSubmit(): void {

    if (!this.form || this.form.invalid) {
      this.form.markAllAsTouched();
      return;
    }

    // Récupération sécurisée des valeurs (non typée)
    const registerRequest: RegisterRequest = {
      firstname: this.form.controls['firstname'].value,
      lastname: this.form.controls['lastname'].value,
      nickname: this.form.controls['nickname'].value,
      dateOfBirth: this.form.controls['dateOfBirth'].value,
      email: this.form.get('email')?.value,
      password: this.form.get('password')?.value,
    };

    this.manager.register(registerRequest).subscribe({
      next: () => {
        console.log('Success'); // TODO : Remove this
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
