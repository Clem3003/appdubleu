import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import {RegisterRequest} from '../../register/register.model';
import {Observable, of, tap} from 'rxjs';
import {StLoUser} from '../login.model';

@Injectable({ providedIn: 'root' })
export class AuthService {
  private readonly API_URL = 'http://localhost:8080/api/auth'; // TODO : switch dev/prod

  constructor(private http: HttpClient) {}

  private currentUser: any = null;

  login(username: string, password: string) {
    return this.http.post(
      `${this.API_URL}/login`,
      { username, password },
      { withCredentials: true } // ✅ indispensable pour gérer JSESSIONID
    ).pipe(
      tap((user: any) => {
        this.currentUser = user; // ← on sauvegarde l'utilisateur
      })
    );
  }

  logout() {
    this.currentUser = null;
    return this.http.post(
      `${this.API_URL}/logout`,
      {},
      { withCredentials: true } // ✅ envoie le cookie pour destruction
    );
  }
  me(): Observable<StLoUser> {
    if (this.currentUser) {
      return of(this.currentUser); // déjà connecté
    }
    return this.http.get<StLoUser>(`${this.API_URL}/me`); // sinon, requête vers le serveur
  }
  register(request: RegisterRequest) {
    return this.http.post(`${this.API_URL}/register`, request, { withCredentials: true });
  }
}
