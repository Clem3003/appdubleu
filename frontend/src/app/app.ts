import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import {LoginForm} from './user/login/login-form/login-form';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, LoginForm],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected readonly title = signal('frontend');
}
