import {SimplifiedStLoUser, StLoUser} from '../user/login/login.model';

export interface PrivateMessageItem {
  id: string;

  recipient: SimplifiedStLoUser;
  isActive: boolean;

  idRead: boolean;

  lastUpdate: Date;

  createdBy: SimplifiedStLoUser;
  createdAt: string;
}
