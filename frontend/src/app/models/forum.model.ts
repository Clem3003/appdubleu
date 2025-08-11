import {StLoUser} from '../user/login/login.model';

export interface PrivateMessageItem {
  id: string;

  recipient: StLoUser;
  isActive: boolean;

  idRead: boolean;

  lastUpdate: Date;

  createdBy: StLoUser;
  createdAt: string;
}
