import {Routes} from '@angular/router';
import {Login} from '../user/login/login';
import {RedirectLoginGuard} from '../RedirectLoginGuard';
import {Dashboard} from './dashboard/dashboard';
import {AuthGuard} from '../user/login/auth/AuthGuard';
import {Features} from './features';
import {Folklore} from './folklore/folklore';
import {Forum} from './forum/forum';
import {Profile} from './profile/profile';
import {FolkloreQuiz} from './folklore-quiz/folklore-quiz';
import {BleuInfo} from './account/bleu-info/bleu-info';
import {Account} from './account/account';
import {Conversation} from './forum/private-messages/conversation/conversation';

const defaultRoutes: Routes = [
  // { path: 'access-denied', component: ErrorComponent, data: { errorCode: 401 } },
  // { path: 'error', component: ErrorComponent },
  // { path: 'under-construction', component: ErrorComponent, data: { errorCode: 69 } },
  // { path: '**', component: ErrorComponent, data: { errorCode: 404 } }
];

const childrenRoutes: Routes = [
    { path: '', component: Dashboard },
    { path: 'dashboard', component: Dashboard },
    { path: 'folklore', component: Folklore },
    { path: 'folklore-quiz', component: FolkloreQuiz },
    { path: 'forum', component: Forum },
    { path: 'account', component: Account },
    { path: 'bleu-info/:username' , component: BleuInfo },
    { path: 'profile', component: Profile },
    { path: 'settings', component: Profile },
    { path: 'messages/:userid', component: Conversation },
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
