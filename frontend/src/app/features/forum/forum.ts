import {Component} from '@angular/core';
import {Card} from 'primeng/card';
import {FormsModule} from '@angular/forms';

@Component({
  selector: 'app-forum',
  imports: [
    Card,
    FormsModule
  ],
  templateUrl: './forum.html'
})
export class Forum {

}
