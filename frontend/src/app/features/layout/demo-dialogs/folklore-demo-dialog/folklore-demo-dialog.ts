import {Component, inject} from '@angular/core';
import {ButtonDirective} from 'primeng/button';
import {DynamicDialogRef} from 'primeng/dynamicdialog';

@Component({
  selector: 'app-folklore-demo-dialog',
  imports: [
    ButtonDirective
  ],
  templateUrl: './folklore-demo-dialog.html'
})
export class FolkloreDemoDialog {
  protected ref: DynamicDialogRef = inject(DynamicDialogRef);

}
