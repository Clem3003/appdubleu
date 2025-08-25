
export interface UserCredentials {
  username: string;
  password: string;
}
export interface SimplifiedStLoUser {
  id: string;
  username: string;
  avatarUrl?: string;
}

export interface StLoBleu {
  id: string;
  username: string;
  nickname: string;
  lastname: string;
}

export interface StLoUser {
  id: string;
  username: string;
  nickname: string;
  email?: string;
  dateOfBirth?: string;
  role?: string;
  lastname: string;
  firstname: string;
  avatarUrl?: string;
}
