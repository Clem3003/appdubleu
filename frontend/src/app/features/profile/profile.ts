import { Component } from '@angular/core';
import {Avatar} from 'primeng/avatar';
import {OverlayBadge} from 'primeng/overlaybadge';
import {Card} from 'primeng/card';
import {PrimeTemplate} from 'primeng/api';
import {TableModule} from 'primeng/table';
import {PennePins} from '../../models/pins.model';
import {ButtonDirective, ButtonIcon, ButtonLabel} from 'primeng/button';

@Component({
  selector: 'app-profile',
  imports: [
    Avatar,
    OverlayBadge,
    Card,
    PrimeTemplate,
    TableModule,
    ButtonDirective,
    ButtonLabel,
    ButtonIcon
  ],
  templateUrl: './profile.html'
})
export class Profile {
  protected userData: any[] = [
    { id: '1', name: 'Bleusailles prestées', value: '4', remark: '' },
    { id: '2', name: 'Bleusailles manquées', value: '1', remark: '' },
    { id: '3', name: 'Mon carnet ', value: '-1/10 (vide)', remark: '' },
    { id: '4', name: 'Points gagnés ajd.', value: '3', remark: '' },
    { id: '5', name: 'Derniers points perdus ', value: '-10 (ne connait pas ses chants)', remark: '' },
    { id: '6', name: 'Tests folklore faits ', value: '13', remark: '' }
  ]

}
