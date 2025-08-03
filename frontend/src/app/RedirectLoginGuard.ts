import { Injectable } from '@angular/core';
import { CanActivate, Router, UrlTree } from '@angular/router';
import { AuthService } from './user/login/auth/auth.service';  // Chemin vers ton service AuthService

@Injectable({
  providedIn: 'root'
})
export class RedirectLoginGuard implements CanActivate {

  constructor(private authService: AuthService, private router: Router) {}

  canActivate(): boolean | UrlTree {
    if (this.authService.isLoggedIn()) {
      console.log("is logged in");
      // Si connecté, rediriger vers la page d'accueil (ou dashboard)
      return this.router.createUrlTree(['/']);
    }
    console.log("is not logged in");
    // Sinon, autoriser l'accès à la page de login
    return true;
  }
}
