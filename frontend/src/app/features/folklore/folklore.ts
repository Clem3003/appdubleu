import {Component, inject} from '@angular/core';
import {Tab, TabList, TabPanel, TabPanels, Tabs} from "primeng/tabs";
import {TabPins} from "./tab-pins/tab-pins";
import {TabChants} from "./tab-chants/tab-chants";
import {TabFolklore} from "./tab-folklore/tab-folklore";
import {Button} from 'primeng/button';
import {QuizTabFolklore} from '../folklore-quiz/quiz-tab-folklore/quiz-tab-folklore';
import {NgIf} from '@angular/common';
import {DialogService, DynamicDialogRef} from 'primeng/dynamicdialog';
import {FolkloreDemoDialog} from '../layout/demo-dialogs/folklore-demo-dialog/folklore-demo-dialog';

@Component({
  selector: 'app-folklore',
  providers: [DialogService],
  imports: [
    Tabs,
    TabList,
    TabPanel,
    TabPanels,
    Tab,
    TabPins,
    TabChants,
    TabFolklore,
    Button,
    QuizTabFolklore,
    NgIf
  ],
  templateUrl: './folklore.html'
})
export class Folklore {
  showQuizTab = false;
  private dialogService: DialogService = inject(DialogService)
  protected ref: DynamicDialogRef | undefined;

  showQuiz(){
    this.showQuizTab = true;
  }

  showFolklore() {
    this.showQuizTab = false;
  }

  toggleFolkloreDemoDialog() {
    this.ref = this.dialogService.open(FolkloreDemoDialog, {
      header: 'Folklore - Info',
      width: '90vw',
      height: '180vw',
    });
  }
}
