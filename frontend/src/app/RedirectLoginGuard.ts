import {Injectable} from '@angular/core';
import {CanActivate, Router} from '@angular/router';
import {catchError, map, of} from 'rxjs';
import {AuthService} from './user/login/auth/auth.service';

@Injectable({ providedIn: 'root' })
export class RedirectLoginGuard implements CanActivate {
  constructor(private authService: AuthService, private router: Router) {}

  canActivate() {
    return this.authService.me().pipe(
      map(user => {
        // ✅ Si connecté → redirige vers l'accueil
        return this.router.createUrlTree(['/']);
      }),
      catchError(() => {
        // ❌ Pas connecté → accès au login autorisé
        return of(true);
      })
    );
  }
}
