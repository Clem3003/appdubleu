import {Component} from '@angular/core';
import {Tab, TabList, TabPanel, TabPanels, Tabs} from "primeng/tabs";
import {QuizTabGeneral} from './quiz-tab-general/quiz-tab-general';
import {QuizTabFolklore} from './quiz-tab-folklore/quiz-tab-folklore';
import {QuizTabChants} from './quiz-tab-chants/quiz-tab-chants';
import {QuizTabPins} from './quiz-tab-pins/quiz-tab-pins';

@Component({
  selector: 'app-folklore-quiz',
  imports: [
    Tab,
    TabList,
    TabPanel,
    TabPanels,
    Tabs,
    QuizTabGeneral,
    QuizTabFolklore,
    QuizTabChants,
    QuizTabPins
  ],
  templateUrl: './folklore-quiz.html',
})
export class FolkloreQuiz {

}
