import { Component } from '@angular/core';
import {Card} from 'primeng/card';
import {Knob} from 'primeng/knob';
import {FormsModule} from '@angular/forms';

@Component({
  selector: 'app-forum',
  imports: [
    Card,
    Knob,
    FormsModule
  ],
  templateUrl: './forum.html'
})
export class Forum {

}
