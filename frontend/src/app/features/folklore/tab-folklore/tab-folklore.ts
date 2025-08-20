import { Component } from '@angular/core';
import {Card} from 'primeng/card';
import {Fluid} from 'primeng/fluid';
import {BaptismalSong, SongTypeEnum} from '../../../models/song.model';
import {FolkloreSubject} from '../../../models/folklore-subject.model';
import {Image} from 'primeng/image';

@Component({
  selector: 'app-tab-folklore',
  imports: [
    Card,
    Image
  ],
  templateUrl: './tab-folklore.html'
})
export class TabFolklore {

  protected folkloreSubjects: FolkloreSubject[] = [
    { id: '1', title: 'L’esplanade des terrasses', content: '', pictureUrl: 'assets/les_terrasses_liege.jpg' },
    { id: '2', title: 'L’exposition de 1905', content: '', pictureUrl: 'assets/expo_1905_liege.jpg' },
    { id: '4', title: 'Monuments Parc d’Avroy', content: '', pictureUrl: 'assets/monuments_avroy_liege.jpg' },
    { id: '5', title: 'Statue de charlemagne', content: '', pictureUrl: '' },
    { id: '6', title: 'L’Eglise Saint-Jacques-le-Mineur', content: '', pictureUrl: '' },
    { id: '7', title: 'Vertbois', content: '', pictureUrl: '' },
    { id: '8', title: 'Les moines de Saint-Bernardin', content: '', pictureUrl: '' },
    { id: '9', title: 'XX août', content: '', pictureUrl: '' },
    { id: '10', title: 'Liège et son Histoire', content: '', pictureUrl: '' },
    { id: '11', title: 'Tchantches', content: '', pictureUrl: '' },
    { id: '12', title: 'Dju d’la moûsse', content: '', pictureUrl: '' },
    { id: '13', title: 'Le Pont des Arches', content: '', pictureUrl: '' },
    { id: '14', title: 'Les Fontaines Montéfiores', content: '', pictureUrl: '' },
    { id: '15', title: 'Statue De G. Simenon', content: '', pictureUrl: '' },
    { id: '16', title: 'Le Perron', content: '', pictureUrl: '' },
    { id: '17', title: 'La Violette', content: '', pictureUrl: '' },
    { id: '18', title: 'Les marches de Bueren', content: '', pictureUrl: '' },
    { id: '19', title: 'La place Saint Lambert', content: '', pictureUrl: '' },
    { id: '20', title: 'Le palais des Princes Evêques', content: '', pictureUrl: '' },
    { id: '21', title: 'L’Opéra', content: '', pictureUrl: '' },
    { id: '22', title: 'La Vierge Delcourt', content: '', pictureUrl: '' },
  ];
}
