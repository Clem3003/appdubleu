import {inject, Injectable, signal, WritableSignal} from '@angular/core';
import {ForumService} from './forum.service';
import {StLoUser} from '../../user/login/login.model';
import {UserService} from '../../user/user.service';

@Injectable({ providedIn: 'root' })
export class ForumManager {
  protected forumService = inject(ForumService);
  protected userService = inject(UserService);

  public allUsernames: WritableSignal<StLoUser[]> = signal([]);

  constructor() {
    console.info('[ForumManager] Initializing forums...');
    this.loadUsernames();
  }

  private loadUsernames() {
    this.userService.loadUserNames().subscribe({
      next: (res: StLoUser[]) => {
        this.allUsernames.set(res);
      },
      error: (err) => {
        console.error('Échec du chargement', err);
      }
    });
  }

}
