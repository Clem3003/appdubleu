import {Component, inject, OnInit} from '@angular/core';
import {
  AbstractControl,
  FormBuilder,
  FormControl,
  FormGroup,
  FormsModule, ReactiveFormsModule,
  ValidatorFn,
  Validators
} from '@angular/forms';
import {RegisterManager} from '../../register/register.manager';
import {Router, RouterLink} from '@angular/router';
import {BleuRegisterRequest} from '../bleu-register.model';
import {ButtonDirective} from 'primeng/button';
import {InputText} from 'primeng/inputtext';

@Component({
  selector: 'app-bleu-register-form',
  imports: [
    ButtonDirective,
    FormsModule,
    InputText,
    ReactiveFormsModule,
    RouterLink
  ],
  templateUrl: './bleu-register-form.html'
})
export class BleuRegisterForm implements OnInit {
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
      telephone: new FormControl('', Validators.required),
      password: new FormControl('', Validators.required),
      confirmPassword: new FormControl('', Validators.required)
    }, { validators: [this.passwordsMatchValidator] });
  }

  private passwordsMatchValidator: ValidatorFn = (group: AbstractControl) => {
    const password = group.get('password')?.value;
    const confirm = group.get('confirmPassword')?.value;
    return password === confirm ? null : { passwordsMismatch: true };
  };

  onSubmit(): void {

    if (!this.form || this.form.invalid) {
      this.form.markAllAsTouched();
      return;
    }

    // Récupération sécurisée des valeurs (non typée)
    const registerRequest: BleuRegisterRequest = {
      firstname: this.form.controls['firstname'].value,
      lastname: this.form.controls['lastname'].value,
      telephone: this.form.controls['dateOfBirth'].value,
      password: this.form.get('password')?.value,
    };

    this.manager.registerBleu(registerRequest).subscribe({
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
