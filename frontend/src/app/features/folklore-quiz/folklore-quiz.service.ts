import {inject, Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Question} from '../../models/question.model';

@Injectable({ providedIn: 'root' })
export class FolkloreQuizService {
  private readonly API_URL = 'https://cbsaintlaurent.be/api/question';

  private http: HttpClient = inject(HttpClient);

  getFolkloreQuizQuestions(): Observable<Question[]> {
    return this.http.get<Question[]>(`${this.API_URL}/getActiveQuestions`);
  }

}
