import {StLoUser} from '../user/login/login.model';
import {BaptismalSong} from './song.model';
import {FolkloreSubject} from './folklore-subject.model';
import {PennePins} from './pins.model';

export interface Question {
  id: string;
  prompt: string;

  baptismalSong: BaptismalSong;
  folkloreSubject: FolkloreSubject;
  pins: PennePins;

  suggestedAnswer_1: string;
  suggestedAnswer_2: string;
  suggestedAnswer_3: string;
  suggestedAnswer_4: string;

  correctAnswer: string;

  createdBy: StLoUser;
  createdAt: string;
}
export interface QuestionAttemptResponse {
  id: string;
  attemptAnswer: string;
  success: boolean;

  createdBy: StLoUser;
  createdAt: string;
}
