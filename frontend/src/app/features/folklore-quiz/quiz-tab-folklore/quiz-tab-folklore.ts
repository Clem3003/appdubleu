import {Component, inject, OnInit, signal, WritableSignal} from '@angular/core';
import {FolkloreQuizManager} from '../folklore-quiz.manager';
import {Image} from 'primeng/image';
import {Button, ButtonSeverity} from 'primeng/button';
import {Divider} from 'primeng/divider';
import {FormBuilder, FormControl, FormGroup, Validators} from '@angular/forms';
import {Question} from '../../../models/question.model';
import {Toast} from 'primeng/toast';
import {MessageService} from 'primeng/api';

@Component({
  selector: 'app-quiz-tab-folklore',
  templateUrl: './quiz-tab-folklore.html',
  imports: [
    Image,
    Button,
    Divider,
    Toast
  ],
  providers: [MessageService]
})
export class QuizTabFolklore implements OnInit {
  protected folkloreQuizManager: FolkloreQuizManager = inject(FolkloreQuizManager);
  private readonly fb = inject(FormBuilder);
  private messageService: MessageService = inject(MessageService);
  protected form!: FormGroup;

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
}
