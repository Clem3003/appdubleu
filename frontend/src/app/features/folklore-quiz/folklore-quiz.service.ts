import {inject, Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Question, QuestionAttemptResponse} from '../../models/question.model';

@Injectable({ providedIn: 'root' })
export class FolkloreQuizService {
  // private readonly API_URL = 'https://cbsaintlaurent.be/api/question'; // TODO : SWITCH DEV/PROD
  private readonly API_URL = 'http://localhost:8080/api/question'; // TODO : SWITCH DEV/PROD

  private http: HttpClient = inject(HttpClient);

  getFolkloreQuizQuestions(): Observable<Question[]> {
    return this.http.get<Question[]>(`${this.API_URL}/getActiveQuestions`);
  }

  getFourRandomActiveQuestions(): Observable<Question[]> {
    return this.http.get<Question[]>(`${this.API_URL}/getFourRandomActiveQuestions`);
  }

  submitAnswer(request: any) {
    return this.http.post<QuestionAttemptResponse>(`${this.API_URL}_attempt`, request);
  }
}
