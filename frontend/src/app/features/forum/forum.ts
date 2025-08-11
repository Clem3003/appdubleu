import {Component} from '@angular/core';
import {Card} from 'primeng/card';
import {FormsModule} from '@angular/forms';
import {Tab, TabList, TabPanel, TabPanels, Tabs} from 'primeng/tabs';
import {TabChants} from '../folklore/tab-chants/tab-chants';
import {TabFolklore} from '../folklore/tab-folklore/tab-folklore';
import {TabGeneral} from '../folklore/tab-general/tab-general';
import {TabPins} from '../folklore/tab-pins/tab-pins';
import {GroupMessages} from './group-messages/group-messages';
import {PrivateMessages} from './private-messages/private-messages';

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
  templateUrl: './forum.html'
})
export class Forum {

}
