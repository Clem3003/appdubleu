import {Component, inject} from '@angular/core';
import {PrivateMessageItem} from '../../../models/forum.model';
import {Divider} from 'primeng/divider';
import {Avatar} from 'primeng/avatar';
import {FormBuilder, FormGroup, FormsModule, ReactiveFormsModule} from '@angular/forms';
import {InputIcon} from 'primeng/inputicon';
import {IconField} from 'primeng/iconfield';
import {InputText} from 'primeng/inputtext';

@Component({
  selector: 'app-private-messages',
  imports: [
    Divider,
    Avatar,
    FormsModule,
    ReactiveFormsModule,
    InputIcon,
    IconField,
    InputText
  ],
  templateUrl: './private-messages.html'
})
export class PrivateMessages {
  protected fb = inject(FormBuilder);

  protected form: FormGroup = this.fb.group({
    search: this.fb.control('', null)
  });

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

}
