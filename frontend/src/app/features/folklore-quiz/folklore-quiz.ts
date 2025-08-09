import {Component, inject} from '@angular/core';
import {Tab, TabList, TabPanel, TabPanels, Tabs} from "primeng/tabs";
import {QuizTabGeneral} from './quiz-tab-general/quiz-tab-general';
import {QuizTabFolklore} from './quiz-tab-folklore/quiz-tab-folklore';
import {QuizTabChants} from './quiz-tab-chants/quiz-tab-chants';
import {QuizTabPins} from './quiz-tab-pins/quiz-tab-pins';
import {FolkloreQuizManager} from './folklore-quiz.manager';

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
  providers: [FolkloreQuizManager],
  templateUrl: './folklore-quiz.html',
})
export class FolkloreQuiz {
  protected manager: FolkloreQuizManager = inject(FolkloreQuizManager);

}
