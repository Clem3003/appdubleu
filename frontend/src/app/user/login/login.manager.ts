import {inject, Injectable} from '@angular/core';
import {AuthService} from './auth/auth.service';
import {tap} from 'rxjs';

@Injectable({ providedIn: 'root' })
export class LoginManager {

  private authService: AuthService = inject(AuthService);

  login(username: string, password: string) {
    return this.authService.login(username, password).pipe(
      tap(res => this.authService.saveToken(res.token))
    );
  }
}
