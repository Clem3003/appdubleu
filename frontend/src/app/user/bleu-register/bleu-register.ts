import { Component } from '@angular/core';
import {Avatar} from 'primeng/avatar';
import {Card} from 'primeng/card';
import {RegisterForm} from '../register/register-form/register-form';
import {BleuRegisterForm} from './bleu-register-form/bleu-register-form';

@Component({
  selector: 'app-bleu-register',
  imports: [
    Avatar,
    Card,
    RegisterForm,
    BleuRegisterForm
  ],
  templateUrl: './bleu-register.html'
})
export class BleuRegister {

}
