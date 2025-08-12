import {Component, inject} from '@angular/core';
import {DynamicDialogRef} from 'primeng/dynamicdialog';
import {ButtonDirective} from 'primeng/button';

@Component({
  selector: 'app-message-demo-dialog',
  imports: [
    ButtonDirective
  ],
  templateUrl: './message-demo-dialog.html'
})
export class MessageDemoDialog {
  protected ref: DynamicDialogRef = inject(DynamicDialogRef);
}
