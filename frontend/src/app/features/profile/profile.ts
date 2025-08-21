import {Component, inject, OnInit, signal, WritableSignal} from '@angular/core';
import {Avatar} from 'primeng/avatar';
import {OverlayBadge} from 'primeng/overlaybadge';
import {Card} from 'primeng/card';
import {PrimeTemplate} from 'primeng/api';
import {TableModule} from 'primeng/table';
import {PennePins} from '../../models/pins.model';
import {Button, ButtonDirective, ButtonIcon, ButtonLabel} from 'primeng/button';
import {Knob} from 'primeng/knob';
import {AuthService} from '../../user/login/auth/auth.service';
import {Image} from 'primeng/image';
import {DataView} from 'primeng/dataview';
import {Product} from '../../models/bleu.model';
import {NgClass, NgForOf, NgIf} from '@angular/common';
import {Tag} from 'primeng/tag';
import {Ripple} from 'primeng/ripple';
import {Badge} from 'primeng/badge';
import {ContextMenu} from 'primeng/contextmenu';
import {Divider} from 'primeng/divider';

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
    ButtonIcon,
    Knob,
    Button,
    Image,
    DataView,
    NgForOf,
    NgClass,
    Tag,
    Ripple,
    Badge,
    NgIf,
    ContextMenu,
    Divider
  ],
  templateUrl: './profile.html'
})
export class Profile implements OnInit {
  protected authService: AuthService = inject(AuthService)

  protected userData: any[] = [
    { id: '1', name: 'Bleusailles prestées', value: '4', remark: '' },
    { id: '2', name: 'Bleusailles manquées', value: '1', remark: '' },
    { id: '3', name: 'Mon carnet ', value: '-1/10 (vide)', remark: '' },
    { id: '4', name: 'Points gagnés ajd.', value: '3', remark: '' },
    { id: '5', name: 'Derniers points perdus ', value: '-10 (ne connait pas ses chants)', remark: '' },
    { id: '6', name: 'Tests folklore faits ', value: '13', remark: '' }
  ]

  protected products: Product[] = [{
        id: '1000',
        name: 'Wilmart Hélicie',
        image: 'https://primefaces.org/cdn/primeng/images/demo/avatar/amyelsner.png',
        price: 65,
        category: 'Accessories',
        status: 'DUMB',
        rating: -5
      },{
        id: '1001',
        name: 'Matteo Wensel',
        image: 'https://primefaces.org/cdn/primeng/images/demo/avatar/elwinsharvill.png',
        price: 65,
        category: 'Accessories',
        status: 'DUMB',
        rating: -5
      },{
        id: '1001',
        name: 'Fiacre Clara',
        image: 'https://primefaces.org/cdn/primeng/images/demo/avatar/asiyajavayant.png',
        price: 65,
        category: 'Accessories',
        status: 'DUMB',
        rating: -5
      },{
        id: '1001',
        name: 'Prince Louise',
        image: 'https://primefaces.org/cdn/primeng/images/demo/avatar/annafali.png',
        price: 65,
        category: 'Accessories',
        status: 'DUMB',
        rating: -5
      },
  ]


  ngOnInit() {

  }

  getSeverity(product: Product) {
    switch (product.status) {
      case 'IN':
        return 'success';

      case 'DUMB':
        return 'warn';

      case 'OUTOFSTOCK':
        return 'danger';

      default:
        return null;
    }
  }

  displayBleu() {

  }
}
