import {Component, inject} from '@angular/core';
import {FormsModule} from '@angular/forms';
import {Tab, TabList, TabPanel, TabPanels, Tabs} from 'primeng/tabs';
import {GroupMessages} from './group-messages/group-messages';
import {PrivateMessages} from './private-messages/private-messages';
import {DialogService, DynamicDialogRef} from 'primeng/dynamicdialog';

@Component({
  selector: 'app-forum',
  imports: [
    FormsModule,
    Tab,
    TabList,
    TabPanel,
    TabPanels,
    Tabs,
    GroupMessages,
    PrivateMessages
  ],
  providers: [DialogService],
  templateUrl: './forum.html'
})
export class Forum {
  private dialogService: DialogService = inject(DialogService)
  protected ref: DynamicDialogRef | undefined;
}
