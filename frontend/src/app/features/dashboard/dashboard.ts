import {Component, inject} from '@angular/core';
import {Card} from 'primeng/card';
import {Knob} from 'primeng/knob';
import {FormsModule} from '@angular/forms';
import {DialogService, DynamicDialogRef} from 'primeng/dynamicdialog';
import {ScoreInfoDialog} from './score-info-dialog/score-info-dialog';

@Component({
  selector: 'app-dashboard',
  providers: [DialogService],
  imports: [
    Card,
    Knob,
    FormsModule
  ],
  templateUrl: './dashboard.html',
})
export class Dashboard {
  private dialogService: DialogService = inject(DialogService)

  protected ref: DynamicDialogRef | undefined;

  showScoreInfoDialog() {
    this.ref = this.dialogService.open(ScoreInfoDialog, {
      header: 'Score - Info',
      width: '90vw',
      height: '180vw',
    });
  }
}
