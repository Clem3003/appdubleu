import {Component, inject} from '@angular/core';
import {FormBuilder, FormGroup, ReactiveFormsModule, Validators} from '@angular/forms';
import {Router} from '@angular/router';
import {Subject} from 'rxjs';
import {UserCredentials} from '../login.model';
import {InputText} from 'primeng/inputtext';

class ControlsOf<T> {
}

@Component({
  selector: 'app-login-form',
  imports: [
    ReactiveFormsModule,
    InputText
  ],
  templateUrl: './login-form.html'
})
export class LoginForm {
  /* private readonly toast = injectToastService(); */
  private readonly fb = inject(FormBuilder);
  private readonly router = inject(Router);
  private readonly onSignIn$ = new Subject<MouseEvent>();

  // private login$ = this.onSignIn$.pipe(
  //   tap(event => FormUtils.markAsTouched(this.form)),
  //   filter(event => this.form.valid),
  //   map(event => this.form.value as UserCredentials),
  //   exhaustMap(credentials =>
  //     this.auth.login(credentials).pipe(
  //       tap(() => this.router.navigate(['/'])), // window.location.reload()
  //       catchError(err => {
  //         this.toast.warn({
  //           detail: this.i18n.instant('error.http.401'),
  //           title: this.i18n.instant('error.unauthorized')
  //         });
  //         return of(null);
  //       })
  //     )
  //   )
  // );

  public form: FormGroup<ControlsOf<UserCredentials>> = this.fb.group<ControlsOf<UserCredentials>>({
    username: this.fb.control('', Validators.required),
    password: this.fb.control('', Validators.required)
  });

  ngOnInit() {
    // this.login$.subscribe();
  }

  signInAsForm(event: MouseEvent) {
    // this.onSignIn$.next(event);
  }
}
