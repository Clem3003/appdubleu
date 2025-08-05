import { Component } from '@angular/core';
import {Card} from 'primeng/card';
import {Fluid} from 'primeng/fluid';
import {BaptismalSong, SongTypeEnum} from '../../../models/song.model';
import {FolkloreSubject} from '../../../models/folklore-subject.model';

@Component({
  selector: 'app-tab-folklore',
  imports: [
    Card
  ],
  templateUrl: './tab-folklore.html'
})
export class TabFolklore {

  protected folkloreSubjects: FolkloreSubject[] = [
    { id: '1', title: 'L’esplanade des terrasses', content: '' },
    { id: '2', title: 'L’exposition de 1905', content: '' },
    { id: '4', title: 'Monuments Parc d’Avroy', content: '' },
    { id: '5', title: 'Statue de charlemagne', content: '' },
    { id: '6', title: 'L’Eglise Saint-Jacques-le-Mineur', content: '' },
    { id: '7', title: 'Vertbois', content: '' },
    { id: '8', title: 'Les moines de Saint-Bernardin', content: '' },
    { id: '9', title: 'XX août', content: '' },
    { id: '10', title: 'Liège et son Histoire', content: '' },
    { id: '11', title: 'Tchantches', content: '' },
    { id: '12', title: 'Dju d’la moûsse', content: '' },
    { id: '13', title: 'Le Pont des Arches', content: '' },
    { id: '14', title: 'Les Fontaines Montéfiores', content: '' },
    { id: '15', title: 'Statue De G. Simenon', content: '' },
    { id: '16', title: 'Le Perron', content: '' },
    { id: '17', title: 'La Violette', content: '' },
    { id: '18', title: 'Les marches de Bueren', content: '' },
    { id: '19', title: 'La place Saint Lambert', content: '' },
    { id: '20', title: 'Le palais des Princes Evêques', content: '' },
    { id: '21', title: 'L’Opéra', content: '' },
    { id: '22', title: 'La Vierge Delcourt', content: '' },
  ];
}
