import { Component } from '@angular/core';
import {Tab, TabList, TabPanel, TabPanels, Tabs} from "primeng/tabs";
import {TabPins} from "./tab-pins/tab-pins";
import {TabChants} from "./tab-chants/tab-chants";
import {TabFolklore} from "./tab-folklore/tab-folklore";
import {TabGeneral} from "./tab-general/tab-general";
import {Button} from 'primeng/button';
import {QuizTabFolklore} from '../folklore-quiz/quiz-tab-folklore/quiz-tab-folklore';
import {NgIf} from '@angular/common';

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
    TabGeneral,
    Button,
    QuizTabFolklore,
    NgIf
  ],
  templateUrl: './folklore.html'
})
export class Folklore {
  showQuizTab = false;

  showQuiz(){
    this.showQuizTab = true;
  }

  showFolklore() {
    this.showQuizTab = false;
  }
}
