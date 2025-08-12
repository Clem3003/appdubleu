import {Component, inject, OnInit, signal, WritableSignal} from '@angular/core';
import {FolkloreQuizManager} from '../folklore-quiz.manager';
import {Image} from 'primeng/image';
import {Button, ButtonSeverity} from 'primeng/button';
import {Divider} from 'primeng/divider';
import {FormBuilder, FormControl, FormGroup, Validators} from '@angular/forms';
import {Question} from '../../../models/question.model';
import {Toast} from 'primeng/toast';
import {MessageService} from 'primeng/api';
import {Step, StepList, StepPanel, StepPanels, Stepper} from 'primeng/stepper';
import {NgForOf} from '@angular/common';
import {ShufflePipe} from '../../../pipe/shuffle.pipe';

@Component({
  selector: 'app-quiz-tab-folklore',
  templateUrl: './quiz-tab-folklore.html',
  imports: [
    Image,
    Button,
    Divider,
    Toast,
    StepPanel,
    StepList,
    Stepper,
    Step,
    StepPanels,
    NgForOf,
    ShufflePipe
  ],
  providers: [MessageService]
})
export class QuizTabFolklore implements OnInit {
  protected folkloreQuizManager: FolkloreQuizManager = inject(FolkloreQuizManager);
  private readonly fb = inject(FormBuilder);
  private messageService: MessageService = inject(MessageService);
  protected form!: FormGroup;

  protected shuffledAnswers1: { label: string, index: number }[] = [];
  protected shuffledAnswers2: { label: string, index: number }[] = [];
  protected shuffledAnswers3: { label: string, index: number }[] = [];
  protected shuffledAnswers4: { label: string, index: number }[] = [];

  protected selectedButton: WritableSignal<number> = signal(-1);
  protected button1Severity: WritableSignal<ButtonSeverity> = signal("secondary");
  protected button2Severity: WritableSignal<ButtonSeverity> = signal("secondary");
  protected button3Severity: WritableSignal<ButtonSeverity> = signal("secondary");
  protected button4Severity: WritableSignal<ButtonSeverity> = signal("secondary");

  ngOnInit(): void {
    this.form = this.fb.group({
      question: this.fb.group({
        id: this.fb.control(null),
      }),
      attemptAnswer: new FormControl('', Validators.required),
    });
    this.shuffleAnswers();

  }

  shuffleAnswers() {
    const question1 = this.folkloreQuizManager.activeQuestions()[0];
    const answers1 = [
      { label: question1.suggestedAnswer_1, index: 1, severity: this.button1Severity() },
      { label: question1.suggestedAnswer_2, index: 2, severity: this.button2Severity() },
      { label: question1.suggestedAnswer_3, index: 3, severity: this.button3Severity() },
      { label: question1.suggestedAnswer_4, index: 4, severity: this.button4Severity() }
    ];

    // Mélange avec Fisher-Yates
    for (let i = answers1.length - 1; i > 0; i--) {
      const j = Math.floor(Math.random() * (i + 1));
      [answers1[i], answers1[j]] = [answers1[j], answers1[i]];
    }

    this.shuffledAnswers1 = answers1;
    //
    const question2 = this.folkloreQuizManager.activeQuestions()[1];
    const answers2 = [
      { label: question2.suggestedAnswer_1, index: 1, severity: this.button1Severity() },
      { label: question2.suggestedAnswer_2, index: 2, severity: this.button2Severity() },
      { label: question2.suggestedAnswer_3, index: 3, severity: this.button3Severity() },
      { label: question2.suggestedAnswer_4, index: 4, severity: this.button4Severity() }
    ];

    // Mélange avec Fisher-Yates
    for (let i = answers2.length - 1; i > 0; i--) {
      const j = Math.floor(Math.random() * (i + 1));
      [answers2[i], answers2[j]] = [answers2[j], answers2[i]];
    }

    this.shuffledAnswers2 = answers2;
    //
    const question3 = this.folkloreQuizManager.activeQuestions()[2];
    const answers3 = [
      { label: question3.suggestedAnswer_1, index: 1, severity: this.button1Severity() },
      { label: question3.suggestedAnswer_2, index: 2, severity: this.button2Severity() },
      { label: question3.suggestedAnswer_3, index: 3, severity: this.button3Severity() },
      { label: question3.suggestedAnswer_4, index: 4, severity: this.button4Severity() }
    ];

    // Mélange avec Fisher-Yates
    for (let i = answers3.length - 1; i > 0; i--) {
      const j = Math.floor(Math.random() * (i + 1));
      [answers3[i], answers3[j]] = [answers3[j], answers3[i]];
    }

    this.shuffledAnswers3 = answers3;
    //
    const question4 = this.folkloreQuizManager.activeQuestions()[3];
    const answers4 = [
      { label: question4.suggestedAnswer_1, index: 1, severity: this.button1Severity() },
      { label: question4.suggestedAnswer_2, index: 2, severity: this.button2Severity() },
      { label: question4.suggestedAnswer_3, index: 3, severity: this.button3Severity() },
      { label: question4.suggestedAnswer_4, index: 4, severity: this.button4Severity() }
    ];

    // Mélange avec Fisher-Yates
    for (let i = answers4.length - 1; i > 0; i--) {
      const j = Math.floor(Math.random() * (i + 1));
      [answers4[i], answers4[j]] = [answers4[j], answers4[i]];
    }

    this.shuffledAnswers4 = answers4;
  }

  getButtonSeverity(index: number) {
    switch(index) {
      case 1: return this.button1Severity();
      case 2: return this.button2Severity();
      case 3: return this.button3Severity();
      case 4: return this.button4Severity();
      default: return 'secondary';
    }
  }

  protected selectAnswer(number: number, item: Question): void {
    if(this.form.get('attemptAnswer')?.value != ""){
      this.button1Severity.set("secondary")
      this.button2Severity.set("secondary")
      this.button3Severity.set("secondary")
      this.button4Severity.set("secondary")
      this.form.patchValue({
        question: {
          id: "",
        },
        attemptAnswer: ""
      });
    }

    if(this.selectedButton() == number){
      this.selectedButton.set(-1);
      return;
    }else{
      this.selectedButton.set(number);
    }

    switch (number) {
      case 1:
        this.button1Severity.set("info")
        this.form.patchValue({
          question: {
            id: item.id,
          },
          attemptAnswer: item.suggestedAnswer_1
        });
        break;
      case 2:
        this.button2Severity.set("info")
        this.form.patchValue({
          question: {
            id: item.id,
          },
          attemptAnswer: item.suggestedAnswer_2
        });
        break;
      case 3:
        this.button3Severity.set("info")
        this.form.patchValue({
          question: {
            id: item.id,
          },
          attemptAnswer: item.suggestedAnswer_3
        });
        break;
      case 4:
        this.button4Severity.set("info")
        this.form.patchValue({
          question: {
            id: item.id,
          },
          attemptAnswer: item.suggestedAnswer_4
        });
        break;
    }

    console.log('selectAnswer');
    console.log(this.form.value);
    console.log(this.form.get('attemptAnswer')?.value);
  }


  onSubmit() {
    console.log("onSubmit", this.form.value);
    if (!this.form || this.form.invalid) {
      return;
    }

    this.folkloreQuizManager.submitAnswer(this.form.value).subscribe({
      next: (res) => {
        if(res.success){
          this.showSuccess()
          console.log('Success !');
        }else{
          this.showError()
          console.error('Faux !');
        }
      },
    });
  }

  showSuccess() {
    this.messageService.add({ severity: 'success', summary: 'Réussi', detail: 'Bonne réponse !' });
  }

  showError() {
    this.messageService.add({ severity: 'error', summary: 'Faux', detail: 'Mauvaise réponse !' });
  }

  resetSelection() {
    if(this.form.get('attemptAnswer')?.value != ""){
      this.button1Severity.set("secondary")
      this.button2Severity.set("secondary")
      this.button3Severity.set("secondary")
      this.button4Severity.set("secondary")
      this.form.patchValue({
        question: {
          id: "",
        },
        attemptAnswer: ""
      });
    }
    this.selectedButton.set(-1);
  }
}
