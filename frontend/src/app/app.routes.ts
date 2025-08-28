import { Routes } from '@angular/router';
import {FEATURES_ROUTES} from './features/features.routes';
import {RedirectLoginGuard} from './RedirectLoginGuard';
import {Login} from './user/login/login';
import {AuthGuard} from './user/login/auth/AuthGuard';
import {Register} from './user/register/register';
import {BleuRegister} from './user/bleu-register/bleu-register';

export const routes: Routes = [
  { path: 'login', component: Login },
  // { path: 'login', component: Login,  canActivate: [RedirectLoginGuard] },
  { path: 'register', component: Register },
  { path: 'bleu-register', component: BleuRegister },
  { path: '', children: FEATURES_ROUTES }
  // { path: '', children: FEATURES_ROUTES, canActivate: [AuthGuard] }
];
