import {inject, Injectable} from '@angular/core';
import {RegisterRequest} from './register.model';
import {AuthService} from '../login/auth/auth.service';

@Injectable({ providedIn: 'root' })
export class RegisterManager {

  private authService: AuthService = inject(AuthService);

  register(request: RegisterRequest) {
    return this.authService.register(request);
  }
}
