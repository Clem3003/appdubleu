import {Component} from '@angular/core';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {RegisterForm} from './register-form/register-form';
import {Avatar} from 'primeng/avatar';
import {Card} from 'primeng/card';

@Component({
  selector: 'app-register',
  imports: [
    FormsModule,
    ReactiveFormsModule,
    RegisterForm,
    Avatar,
    Card
  ],
  templateUrl: './register.html'
})
export class Register {

}
