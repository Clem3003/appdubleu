import {HttpClient} from '@angular/common/http';
import {inject, Injectable} from '@angular/core';
import {Router} from '@angular/router';
import {StLoUser} from './login/login.model';

@Injectable({ providedIn: 'root' })
export class UserService {
  // private readonly API_URL = 'http://localhost:8080/api/user'; // TODO : switch dev/prod
  private readonly API_URL = 'http://192.168.68.65:8080/api/user'; // TODO : switch dev/prod
  private router: Router = inject(Router);

  constructor(private http: HttpClient) {}

  loadUserNames() {
    return this.http.get<StLoUser[]>(
      `${this.API_URL}/all-usernames`,
      { withCredentials: true }
    );
  }

}
