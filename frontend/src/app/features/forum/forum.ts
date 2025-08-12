import {Component, inject} from '@angular/core';
import {Card} from 'primeng/card';
import {FormsModule} from '@angular/forms';
import {Tab, TabList, TabPanel, TabPanels, Tabs} from 'primeng/tabs';
import {TabChants} from '../folklore/tab-chants/tab-chants';
import {TabFolklore} from '../folklore/tab-folklore/tab-folklore';
import {TabGeneral} from '../folklore/tab-general/tab-general';
import {TabPins} from '../folklore/tab-pins/tab-pins';
import {GroupMessages} from './group-messages/group-messages';
import {PrivateMessages} from './private-messages/private-messages';
import {FolkloreDemoDialog} from '../layout/demo-dialogs/folklore-demo-dialog/folklore-demo-dialog';
import {DialogService, DynamicDialogRef} from 'primeng/dynamicdialog';

@Component({
  selector: 'app-forum',
  imports: [
    Card,
    FormsModule,
    Tab,
    TabChants,
    TabFolklore,
    TabGeneral,
    TabList,
    TabPanel,
    TabPanels,
    TabPins,
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

  toggleForumDemoDialog() {
    this.ref = this.dialogService.open(FolkloreDemoDialog, {
      header: 'Forum - Info',
      width: '90vw',
      height: '180vw',
    });
  }
}
