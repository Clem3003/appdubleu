import { Injectable } from '@angular/core';
import { CanActivate, Router } from '@angular/router';
import { AuthService } from './auth.service';
import {map, of} from 'rxjs';
import {catchError} from 'rxjs/operators';

@Injectable({ providedIn: 'root' })
export class AuthGuard implements CanActivate {
  constructor(private authService: AuthService, private router: Router) {}

  canActivate() {
    return this.authService.me().pipe(
      map(user => {
        // ✅ L'utilisateur est connecté
        return true;
      }),
      catchError(() => {
        // ❌ Pas connecté → redirection
        return of(this.router.createUrlTree(['/login']));
      })
    );
  }
}
