import {Routes} from '@angular/router';
import {Login} from '../user/login/login';
import {RedirectLoginGuard} from '../RedirectLoginGuard';
import {Dashboard} from './dashboard/dashboard';
import {AuthGuard} from '../user/login/auth/AuthGuard';
import {Features} from './features';
import {Folklore} from './folklore/folklore';

const defaultRoutes: Routes = [
  // { path: 'access-denied', component: ErrorComponent, data: { errorCode: 401 } },
  // { path: 'error', component: ErrorComponent },
  // { path: 'under-construction', component: ErrorComponent, data: { errorCode: 69 } },
  // { path: '**', component: ErrorComponent, data: { errorCode: 404 } }
];

const childrenRoutes: Routes = [
    { path: 'dashboard', component: Dashboard },
    { path: 'folklore', component: Folklore },
    { path: 'forum', component: Dashboard },
    { path: 'profile', component: Dashboard },
  // {
  //   path: 'evacuation',
  //   data: { ...withBreadcrumb({ label: marker('menu.evacuation'), link: false }) },
  //   loadChildren: () => import('@app/features/evacuation/evacuation.routes')
  // },
  // {
  //   path: 'referentials',
  //   data: { ...withBreadcrumb({ label: marker('menu.referentials'), link: false }) },
  //   loadChildren: () => import('@app/features/referentials/referentials.routes')
  // },
  // {
  //   path: 'security',
  //   data: { ...withBreadcrumb({ label: marker('menu.security.user-management'), link: false }) },
  //   loadChildren: () => import('@app/features/security/security.routes')
  // }
  // /* PLOP_FEATURE */
];
export const FEATURES_ROUTES: Routes = [
  {
    path: '',
    // canActivate: [AuthGuard],
    children: [...childrenRoutes, ...defaultRoutes],
    component: Features,
  }
];
