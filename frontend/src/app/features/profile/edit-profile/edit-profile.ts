import {Component, effect, inject, OnInit, WritableSignal} from '@angular/core';
import {Avatar} from 'primeng/avatar';
import {Card} from 'primeng/card';
import {ButtonDirective} from 'primeng/button';
import {InputText} from 'primeng/inputtext';
import {
  AbstractControl,
  FormBuilder,
  FormControl,
  FormGroup,
  ReactiveFormsModule,
  ValidatorFn,
  Validators
} from '@angular/forms';
import {RegisterManager} from '../../../user/register/register.manager';
import {Router, RouterLink} from '@angular/router';
import {RegisterRequest} from '../../../user/register/register.model';
import {AuthService} from '../../../user/login/auth/auth.service';
import {StLoUser} from '../../../user/login/login.model';

@Component({
  selector: 'app-edit-profile',
  imports: [
    Avatar,
    Card,
    ButtonDirective,
    InputText,
    ReactiveFormsModule,
    RouterLink
  ],
  templateUrl: './edit-profile.html'
})
export class EditProfile implements  OnInit {
  private readonly fb = inject(FormBuilder);
  protected form!: FormGroup;
  private manager = inject(RegisterManager);
  private authService = inject(AuthService);
  private readonly router = inject(Router);

  private user: WritableSignal<StLoUser | null> = this.authService.currentUser;
  protected loading: boolean = true;


  constructor() {
    effect(() => {
      const user = this.user();
      if (user) {
        this.initForm(user);
      }
    });

  }

  ngOnInit() {
  }

  private initForm(user: StLoUser): void {
    const today = new Date();
    const defaultDate = new Date(today.getFullYear() - 16, today.getMonth(), today.getDate());
    const defaultDateStr = defaultDate.toISOString().split('T')[0]; // format 'YYYY-MM-DD'

    this.form = this.fb.group({
      firstname: new FormControl(user.firstname, Validators.required),
      lastname: new FormControl(user.lastname, Validators.required),
      nickname: new FormControl(user.nickname, Validators.required),
      email: new FormControl(user.email, Validators.required),
      dateOfBirth: new FormControl(user.dateOfBirth, Validators.required),
      password: new FormControl('', Validators.required),
      confirmPassword: new FormControl('', Validators.required)
    }, { validators: [this.passwordsMatchValidator] });
    this.loading = false;
  }

  private passwordsMatchValidator: ValidatorFn = (group: AbstractControl) => {
    const password = group.get('password')?.value;
    const confirm = group.get('confirmPassword')?.value;
    return password === confirm ? null : { passwordsMismatch: true };
  };

  onSubmit(): void {
    console.log("submit");
    console.log(this.form.value);

    // if (!this.form || this.form.invalid) {
    //   this.form.markAllAsTouched();
    //   return;
    // }
    //
    // // Récupération sécurisée des valeurs (non typée)
    // const registerRequest: RegisterRequest = {
    //   firstname: this.form.controls['firstname'].value,
    //   lastname: this.form.controls['lastname'].value,
    //   nickname: this.form.controls['nickname'].value,
    //   dateOfBirth: this.form.controls['dateOfBirth'].value,
    //   email: this.form.get('email')?.value,
    //   password: this.form.get('password')?.value,
    // };
    //
    // this.manager.register(registerRequest).subscribe({
    //   next: () => {
    //     console.log('Success'); // TODO : Remove this
    //     this.router.navigate(['/']);
    //   },
    //   error: (err) => {
    //     console.error('Échec de la connexion', err);
    //   }
    // });
    //
  }
}
