import { Routes } from '@angular/router';
import {FEATURES_ROUTES} from './features/features.routes';
import {RedirectLoginGuard} from './RedirectLoginGuard';
import {Login} from './user/login/login';

export const routes: Routes = [
  { path: 'login', component: Login,  /*canActivate: [RedirectLoginGuard]*/ },
  { path: '', children: FEATURES_ROUTES }
];
