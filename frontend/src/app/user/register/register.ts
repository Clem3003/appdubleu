import {Component} from '@angular/core';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {RegisterForm} from './register-form/register-form';

@Component({
  selector: 'app-register',
  imports: [
    FormsModule,
    ReactiveFormsModule,
    RegisterForm
  ],
  templateUrl: './register.html'
})
export class Register {

}
