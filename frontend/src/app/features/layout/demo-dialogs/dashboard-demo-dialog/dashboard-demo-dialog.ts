import {Component, inject} from '@angular/core';
import {ButtonDirective} from 'primeng/button';
import {Knob} from 'primeng/knob';
import {DynamicDialogRef} from 'primeng/dynamicdialog';

@Component({
  selector: 'app-dashboard-demo-dialog',
  imports: [
    ButtonDirective,
    Knob
  ],
  templateUrl: './dashboard-demo-dialog.html'
})
export class DashboardDemoDialog {
  protected ref: DynamicDialogRef = inject(DynamicDialogRef);

}
