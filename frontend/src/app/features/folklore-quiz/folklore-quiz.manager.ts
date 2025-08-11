import {inject, Injectable, Signal} from '@angular/core';
import {derivedAsync} from 'ngxtension/derived-async';
import {of, tap, timeout} from 'rxjs';
import {catchError} from 'rxjs/operators';
import {FolkloreQuizService} from './folklore-quiz.service';
import {Question} from '../../models/question.model';

@Injectable({ providedIn: 'root' })
export class FolkloreQuizManager {
  private folkloreQuizService: FolkloreQuizService = inject(FolkloreQuizService);

  // Evacuation Info
  // @ts-ignore
  public readonly activeQuestions: Signal<Question[]> = derivedAsync(() => this.folkloreQuizService.getFolkloreQuizQuestions().pipe(catchError(() => of(null))));

  constructor() {
    console.log('FolkloreManager created');
    console.log(this.activeQuestions());
    setTimeout(() => {
      console.log('FolkloreManager created');
      console.log(this.activeQuestions());
    }, 3000);
  }

  // constructor() {
  //   this.hasTriggerEvacuationPermission$
  //     .pipe(
  //       filter(canTriggerEvacuation => canTriggerEvacuation),
  //       switchMap(() => this.fetchEmployeesCount()),
  //       switchMap(() => this.fetchVisitsCount())
  //     )
  //     .subscribe();
  //
  //   this.initSseListeners();
  // }
  //
  //
  // private fetchEmployeesCount(): Observable<number> {
  //   return this.employeeService.loadEmployeeCounter().pipe(tap(count => this.employeesCount.set(count)));
  // }
  //
  // private showEvacuationTriggeredWarning(eventData) {
  //   if (eventData?.trim() !== this.authenticationService.current().username?.trim()) {
  //     const title = this.i18n.instant(marker('menu.dashboard.occupation-card.evac-triggered.warning-dialog-title'));
  //     const confirm = this.i18n.instant(marker('menu.dashboard.occupation-card.evac-triggered.warning-dialog-warning'));
  //     const icon = 'fa-portal-exit fa-2x fad text-orange-500';
  //     this.confirmService.warning(confirm, title, icon).then(confirm => {
  //       if(confirm){
  //         window.location.reload();
  //       }
  //     });
  //   }
  // }
  submitAnswer(value: any) {
    return this.folkloreQuizService.submitAnswer(value);
  }
}
