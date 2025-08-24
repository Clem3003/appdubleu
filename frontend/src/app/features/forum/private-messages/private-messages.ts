import {Component, inject, OnInit, WritableSignal} from '@angular/core';
import {PrivateMessageItem} from '../../../models/forum.model';
import {Divider} from 'primeng/divider';
import {Avatar} from 'primeng/avatar';
import {FormBuilder, FormGroup, FormsModule, ReactiveFormsModule} from '@angular/forms';
import {InputIcon} from 'primeng/inputicon';
import {IconField} from 'primeng/iconfield';
import {InputText} from 'primeng/inputtext';
import {StLoUser} from '../../../user/login/login.model';
import {ForumManager} from '../forum.manager';
import {AutoComplete, AutoCompleteCompleteEvent, AutoCompleteSelectEvent} from 'primeng/autocomplete';
import {PrimeTemplate} from 'primeng/api';
import {Router} from '@angular/router';

@Component({
  selector: 'app-private-messages',
  imports: [
    Divider,
    Avatar,
    FormsModule,
    ReactiveFormsModule,
    InputIcon,
    IconField,
    InputText,
    AutoComplete,
    PrimeTemplate
  ],
  templateUrl: './private-messages.html'
})
export class PrivateMessages implements OnInit {
  private readonly router = inject(Router);
  protected fb = inject(FormBuilder);
  protected forumManager: ForumManager = inject(ForumManager);

  protected form: FormGroup = this.fb.group({
    search: this.fb.control('', null)
  });


  ngOnInit() {
    console.log("test");

    console.log(this.forumManager.allUsernames());
  }

  protected privateMessages: PrivateMessageItem[] = [
    {
      id: 'msg-001',
      recipient: {
        id: 'user-002',
        username: 'Huberland Louis',
        avatarUrl: 'https://primefaces.org/cdn/primeng/images/demo/avatar/amyelsner.png'
      },
      isActive: true,
      idRead: false,
      lastUpdate: new Date('2025-08-10T15:30:00Z'),
      createdBy: {
        id: 'user-001',
        username: 'Clément Lemlijn'
      },
      createdAt: '2025-08-10T14:00:00Z'
    },
    {
      id: 'msg-002',
      recipient: {
        id: 'user-003',
        username: 'Marie Dupont',
        avatarUrl: 'https://primefaces.org/cdn/primeng/images/demo/avatar/asiyajavayant.png'
      },
      isActive: false,
      idRead: true,
      lastUpdate: new Date('2025-08-09T10:15:00Z'),
      createdBy: {
        id: 'user-004',
        username: 'Jean Martin'
      },
      createdAt: '2025-08-09T09:45:00Z'
    },
    {
      id: 'msg-003',
      recipient: {
        id: 'user-005',
        username: 'Thomas Leroy',
        avatarUrl: 'https://primefaces.org/cdn/primeng/images/demo/avatar/onyamalimba.png'
      },
      isActive: true,
      idRead: false,
      lastUpdate: new Date('2025-08-11T08:05:00Z'),
      createdBy: {
        id: 'user-001',
        username: 'Clément Lemlijn'
      },
      createdAt: '2025-08-11T08:00:00Z'
    }
  ];

  showSuggestions() {
    console.log(this.forumManager.allUsernames());
  }

  filteredUsernames: StLoUser[] = [];

  filterUsers(event: any) {
    const query = event.query.toLowerCase();
    this.filteredUsernames = this.forumManager.allUsernames().filter(user =>
      this.getDisplayName(user).toLowerCase().includes(query)
    );
  }

  getDisplayName(user: StLoUser): string {
    return `${user.firstname} "${user.nickname}" ${user.lastname}`;
  }
  getWSignalDisplayNames(): string[] {
    return this.forumManager.allUsernames().map(user =>
      `${user.firstname} "${user.nickname}" ${user.lastname}`
    );
  }

  openConversation($event: AutoCompleteSelectEvent) {
    console.log("Ouvrir la conversation avec :", $event);
    const user: StLoUser = $event.value;

    // Redirection vers la page de conversation (exemple)
    this.router.navigate(['/messages', user.id]);
  }
}
