import {Component, Input, OnInit, Signal} from '@angular/core';
import {Question} from '../../../models/question.model';

@Component({
  selector: 'app-quiz-tab-folklore',
  templateUrl: './quiz-tab-folklore.html',
})
export class QuizTabFolklore implements OnInit {
  @Input() folkloreQuestions!: Signal<Question[] | unknown>;

  ngOnInit(): void {
    // const questions = this.folkloreQuestions();
    // console.log("Questions :", questions);
    // console.log("Nombre de questions :", questions.length ?? 0);
  }



}
