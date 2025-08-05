
export enum SongTypeEnum {
  SACRED_SONG = 'SACRED_SONG',
  COMMITTEE_SONG = 'COMMITTEE_SONG',
  TRADITIONAL_SONG = 'OTHER_SONG'
}

export interface BaptismalSong {
  id: string;
  title: string;
  songType: SongTypeEnum;
  content: string;
}
