import {Component, inject} from '@angular/core';
import {DynamicDialogRef} from 'primeng/dynamicdialog';
import {ButtonDirective} from 'primeng/button';
import {Knob} from 'primeng/knob';
import {FormsModule} from '@angular/forms';

@Component({
  selector: 'app-score-info-dialog',
  imports: [
    ButtonDirective,
    Knob,
    FormsModule
  ],
  templateUrl: './score-info-dialog.html'
})
export class ScoreInfoDialog {
  // TODO : Fix RangeError in console when openning this
  protected ref: DynamicDialogRef = inject(DynamicDialogRef);

}
