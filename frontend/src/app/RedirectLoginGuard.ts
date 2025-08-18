import {map, of} from 'rxjs';
import {catchError} from 'rxjs/operators';
import {AuthService} from './user/login/auth/auth.service';
import {CanActivate, Router} from '@angular/router';
import {Injectable} from '@angular/core';

@Injectable({ providedIn: 'root' })
export class RedirectLoginGuard implements CanActivate {
  constructor(private authService: AuthService, private router: Router) {}

  canActivate() {
    return this.authService.me().pipe(
      map(user => {
        if (user && user.username) {
          // Déjà connecté → redirige vers home
          return this.router.createUrlTree(['/']);
        } else {
          // Pas connecté → peut accéder à login
          return true;
        }
      }),
      catchError(() => of(true)) // pas connecté → peut accéder à login
    );
  }
}
