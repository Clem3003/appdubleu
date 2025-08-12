import {Component, inject} from '@angular/core';
import {DynamicDialogRef} from 'primeng/dynamicdialog';
import {ButtonDirective} from 'primeng/button';

@Component({
  selector: 'app-demo-dialog',
  imports: [
    ButtonDirective
  ],
  templateUrl: './demo-dialog.html'
})
export class DemoDialog {
  protected ref: DynamicDialogRef = inject(DynamicDialogRef);

}
