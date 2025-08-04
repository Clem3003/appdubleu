import { Component } from '@angular/core';
import {Tab, TabList, TabPanel, TabPanels, Tabs} from "primeng/tabs";
import {TabPins} from "./tab-pins/tab-pins";
import {TabChants} from "./tab-chants/tab-chants";
import {TabFolklore} from "./tab-folklore/tab-folklore";
import {TabGeneral} from "./tab-general/tab-general";

@Component({
  selector: 'app-folklore',
    imports: [
        Tabs,
        TabList,
        TabPanel,
        TabPanels,
        Tab,
        TabPins,
        TabChants,
        TabFolklore,
        TabGeneral
    ],
  templateUrl: './folklore.html'
})
export class Folklore {

}
