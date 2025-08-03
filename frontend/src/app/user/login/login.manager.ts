import {inject, Injectable} from '@angular/core';
import {AuthService} from './auth/auth.service';
import {Router} from '@angular/router';
import {tap} from 'rxjs';

@Injectable()
export class LoginManager {

  private authService: AuthService = inject(AuthService);
  private readonly router = inject(Router);

  login(username: string, password: string) {
    return this.authService.login(username, password).pipe(
      tap(res => this.authService.saveToken(res.token))
    );
  }
}
