import { Component } from '@angular/core';
import {Skeleton} from 'primeng/skeleton';
import {NgClass, NgForOf, NgIf} from '@angular/common';
import {Divider} from 'primeng/divider';
import {ButtonDirective} from 'primeng/button';
import {Card} from 'primeng/card';
import {Toolbar} from 'primeng/toolbar';
import {Tag} from 'primeng/tag';
import {OverlayBadge} from 'primeng/overlaybadge';
import {Avatar} from 'primeng/avatar';
import {Rating} from 'primeng/rating';
import {Badge} from 'primeng/badge';
import {FormsModule} from '@angular/forms';
import {ProgressBar} from 'primeng/progressbar';
import {TableModule} from 'primeng/table';
import {Chip} from 'primeng/chip';
import {PennePins} from '../../../models/pins.model';

@Component({
  selector: 'app-bleu-info',
  imports: [
    Skeleton,
    NgIf,
    Divider,
    ButtonDirective,
    Card,
    Toolbar,
    Tag,
    OverlayBadge,
    Avatar,
    Rating,
    Badge,
    FormsModule,
    ProgressBar,
    TableModule,
    Chip,
    NgForOf,
    NgClass
  ],
  templateUrl: './bleu-info.html'
})
export class BleuInfo {
  maxStars: number = 5;
  redValue: number = 2;
  greenValue: number = 0;

  protected stats: any[] = [
    { id: '1', name: 'Bleusailles prestées', value: '4', remark: '' },
    { id: '2', name: 'Bleusailles manquées', value: '1', remark: '' },
    { id: '3', name: 'Mon carnet ', value: '-1/10 (vide)', remark: '' },
    { id: '4', name: 'Points gagnés ajd.', value: '3', remark: '' },
    { id: '5', name: 'Derniers points perdus ', value: '-10 (ne connait pas ses chants)', remark: '' },
    { id: '6', name: 'Tests folklore faits ', value: '13', remark: '' }
  ]

  comments = [
    { author: 'Anonyme', content: 'J\'espère que tu connais ton gaudéamous ce soir bleuette !', iconSeverity: 'text-danger', bgColor: 'rgba(255, 0, 0, 0.1)' },
    { author: 'Louise Prince', content: 'Courage Hélico ! je penserai à toi au stand folklore', iconSeverity: 'text-primary', bgColor: 'rgba(0, 255, 0, 0.1)' },
    { author: 'Anonyme', content: 'Cet espèce de golmonne ne sait pas où est né Tchantchès...', iconSeverity: 'text-danger', bgColor: 'rgba(255, 0, 0, 0.1)' }
  ];


}
