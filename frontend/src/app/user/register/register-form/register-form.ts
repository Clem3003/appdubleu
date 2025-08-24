import {Component, inject, OnInit} from '@angular/core';
import {
  AbstractControl,
  FormBuilder,
  FormControl,
  FormGroup,
  FormsModule,
  ReactiveFormsModule,
  ValidatorFn,
  Validators
} from '@angular/forms';
import {Router, RouterLink} from '@angular/router';
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
    ButtonDirective,
    RouterLink
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
    const today = new Date();
    const defaultDate = new Date(today.getFullYear() - 16, today.getMonth(), today.getDate());
    const defaultDateStr = defaultDate.toISOString().split('T')[0]; // format 'YYYY-MM-DD'

    this.form = this.fb.group({
      firstname: new FormControl('', Validators.required),
      lastname: new FormControl('', Validators.required),
      nickname: new FormControl('', Validators.required),
      email: new FormControl('', Validators.required),
      dateOfBirth: new FormControl(defaultDateStr, Validators.required),
      password: new FormControl('', Validators.required),
      confirmPassword: new FormControl('', Validators.required)
    }, { validators: [this.passwordsMatchValidator, this.agedEnoughValidator] });
  }

  private passwordsMatchValidator: ValidatorFn = (group: AbstractControl) => {
    const password = group.get('password')?.value;
    const confirm = group.get('confirmPassword')?.value;
    return password === confirm ? null : { passwordsMismatch: true };
  };

  private agedEnoughValidator: ValidatorFn = (group: AbstractControl) => {
    const dob = group.get('dateOfBirth')?.value;
    if (!dob) return null;

    const birthDate = new Date(dob);
    const today = new Date();

    // Calcul de l'âge
    let age = today.getFullYear() - birthDate.getFullYear();
    const m = today.getMonth() - birthDate.getMonth();
    if (m < 0 || (m === 0 && today.getDate() < birthDate.getDate())) {
      age--;
    }

    return age >= 17 ? null : { tooYoung: true };
  };

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
