
export interface UserCredentials {
  username: string;
  password: string;
}
export interface SimplifiedStLoUser {
  id: string;
  username: string;
  avatarUrl?: string;
}
export interface StLoUser {
  id: string;
  username: string;
  nickname: string;
  role?: string;
  lastname: string;
  firstname: string;
  avatarUrl?: string;
}
