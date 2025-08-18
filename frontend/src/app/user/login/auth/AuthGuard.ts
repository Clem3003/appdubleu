import { Injectable } from '@angular/core';
import { CanActivate, Router } from '@angular/router';
import { AuthService } from './auth.service';
import {map, of} from 'rxjs';
import {catchError} from 'rxjs/operators';

@Injectable({ providedIn: 'root' })
export class AuthGuard implements CanActivate {
  constructor(private authService: AuthService, private router: Router) {}

  canActivate() {
    console.log('AuthGuard: canActivate');
    return this.authService.me().pipe(
      map(user => {
        console.log('me() response', user);
        if (user && user.username) {
          return true;
        } else {
          return this.router.createUrlTree(['/login']);
        }
      }),
      catchError(err => {
        console.log('me() error', err);
        return of(this.router.createUrlTree(['/login']));
      }))
  }
}
