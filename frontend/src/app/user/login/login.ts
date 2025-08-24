import { Component } from '@angular/core';
import {LoginForm} from './login-form/login-form';
import {Avatar} from 'primeng/avatar';
import {Card} from 'primeng/card';
import {RegisterForm} from '../register/register-form/register-form';

@Component({
  selector: 'app-login',
  imports: [
    LoginForm,
    Avatar,
    Card,
    RegisterForm
  ],
  templateUrl: './login.html',
})
export class Login {

}
