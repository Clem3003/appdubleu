import {inject, Injectable} from '@angular/core';
import {AuthService} from '../login/auth/auth.service';
import {BleuRegisterRequest} from './bleu-register.model';

@Injectable({ providedIn: 'root' })
export class BleuRegisterManager {

  private authService: AuthService = inject(AuthService);

  register(request: BleuRegisterRequest) {
    return this.authService.registerBleu(request);
  }
}
