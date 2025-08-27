import { Component } from '@angular/core';
import {Card} from 'primeng/card';
import {Fluid} from 'primeng/fluid';
import {BaptismalSong, SongTypeEnum} from '../../../models/song.model';
import {FolkloreSubject} from '../../../models/folklore-subject.model';
import {Image} from 'primeng/image';
import {Button} from 'primeng/button';
import {RouterLink} from '@angular/router';

@Component({
  selector: 'app-tab-folklore',
  imports: [
    Card,
    Image,
    Button,
    RouterLink
  ],
  templateUrl: './tab-folklore.html'
})
export class TabFolklore {

  protected folkloreSubjects: FolkloreSubject[] = [
    { id: '11', title: 'Tchantches', content: '', pictureUrl: 'assets/tchantches.jpg', preview: 'Tchantchès, une figure incontournable du folklore liégeois symbolise l’esprit et le caractère du peuple de Liège. On le retrouve chaque année au cœur des grandes traditions populaires.' },
    { id: '1', title: 'L’esplanade des terrasses', content: '', pictureUrl: 'assets/les_terrasses_liege.jpg', preview: 'Un lieu façonné par l’histoire, où les traces d’hier se mêlent à l’identité d’aujourd’hui.\n' +
        'Entre mémoire et usage populaire, ce récit esquisse l’âme d’un quartier singulier.' },
    { id: '2', title: 'L’exposition de 1905', content: '', pictureUrl: 'assets/expo_1905_liege.jpg', preview: '' },
    { id: '4', title: 'Monuments Parc d’Avroy', content: '', pictureUrl: 'assets/monuments_avroy_liege.jpg', preview: '' },
    { id: '5', title: 'Statue de charlemagne', content: '', pictureUrl: '', preview: '' },
    { id: '6', title: 'L’Eglise Saint-Jacques-le-Mineur', content: '', pictureUrl: '', preview: '' },
    { id: '7', title: 'Vertbois', content: '', pictureUrl: '', preview: '' },
    { id: '8', title: 'Les moines de Saint-Bernardin', content: '', pictureUrl: '', preview: '' },
    { id: '9', title: 'XX août', content: '', pictureUrl: '', preview: '' },
    { id: '10', title: 'Liège et son Histoire', content: '', pictureUrl: '', preview: '' },
    { id: '12', title: 'Dju d’la moûsse', content: '', pictureUrl: '', preview: '' },
    { id: '13', title: 'Le Pont des Arches', content: '', pictureUrl: '', preview: '' },
    { id: '14', title: 'Les Fontaines Montéfiores', content: '', pictureUrl: '', preview: '' },
    { id: '15', title: 'Statue De G. Simenon', content: '', pictureUrl: '', preview: '' },
    { id: '16', title: 'Le Perron', content: '', pictureUrl: '', preview: '' },
    { id: '17', title: 'La Violette', content: '', pictureUrl: '', preview: '' },
    { id: '18', title: 'Les marches de Bueren', content: '', pictureUrl: '', preview: '' },
    { id: '19', title: 'La place Saint Lambert', content: '', pictureUrl: '', preview: '' },
    { id: '20', title: 'Le palais des Princes Evêques', content: '', pictureUrl: '', preview: '' },
    { id: '21', title: 'L’Opéra', content: '', pictureUrl: '', preview: '' },
    { id: '22', title: 'La Vierge Delcourt', content: '', pictureUrl: '', preview: '' },
  ];
}
