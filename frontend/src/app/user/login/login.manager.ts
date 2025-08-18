import {inject, Injectable} from '@angular/core';
import {AuthService} from './auth/auth.service';
import {tap} from 'rxjs';
import {Router} from '@angular/router';

@Injectable({ providedIn: 'root' })
export class LoginManager {
  private authService: AuthService = inject(AuthService);
  private router: Router = inject(Router);

  login(username: string, password: string) {
    return this.authService.login(username, password);
  }

  logout() {
    return this.authService.logout();
  }

  me() {
    return this.authService.me();
  }
}

