import {Component, inject, OnInit} from '@angular/core';
import {AuthService} from '../../user/login/auth/auth.service';
import {Product} from '../../models/bleu.model';
import {Avatar} from 'primeng/avatar';
import {ButtonDirective, ButtonIcon, ButtonLabel} from 'primeng/button';
import {Card} from 'primeng/card';
import {Divider} from 'primeng/divider';
import {PrimeTemplate} from 'primeng/api';
import {TableModule} from 'primeng/table';
import {RouterLink} from '@angular/router';

@Component({
  selector: 'app-account',
  imports: [
    Avatar,
    ButtonDirective,
    ButtonIcon,
    ButtonLabel,
    Card,
    Divider,
    PrimeTemplate,
    TableModule,
    RouterLink
  ],
  templateUrl: './account.html'
})
export class Account implements OnInit {
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
    username: 'wilmart.helicie',
    image: 'https://primefaces.org/cdn/primeng/images/demo/avatar/amyelsner.png',
    price: 200,
    category: 'Accessories',
    status: 'DUMB',
    rating: -5
  },{
    id: '1001',
    name: 'Matteo Wensel',
    username: 'matteo.wensel',
    image: 'https://primefaces.org/cdn/primeng/images/demo/avatar/elwinsharvill.png',
    price: 1,
    category: 'Accessories',
    status: 'DUMB',
    rating: -5
  },{
    id: '1001',
    name: 'Fiacre Clara',
    username: 'fiacre.clara',
    image: 'https://primefaces.org/cdn/primeng/images/demo/avatar/asiyajavayant.png',
    price: 40,
    category: 'Accessories',
    status: 'DUMB',
    rating: -5
  },{
    id: '1001',
    name: 'Prince Louise',
    username: 'prince.louise',
    image: 'https://primefaces.org/cdn/primeng/images/demo/avatar/annafali.png',
    price: 70,
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

  displayProduct() {
    console.log("displayBleu");
  }

  deleteProduct() {
    console.log("deleteBleu");
  }
}
