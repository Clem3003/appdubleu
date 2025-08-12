import {Component, inject, OnInit} from '@angular/core';
import {Card} from 'primeng/card';
import {Knob} from 'primeng/knob';
import {FormsModule} from '@angular/forms';
import {DialogService, DynamicDialogRef} from 'primeng/dynamicdialog';
import {ScoreInfoDialog} from './score-info-dialog/score-info-dialog';
import {Carousel} from 'primeng/carousel';
import {Tag} from 'primeng/tag';
import {Button} from 'primeng/button';
import {NgStyle} from '@angular/common';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {AuthService} from '../../user/login/auth/auth.service';
import {DashboardDemoDialog} from '../layout/demo-dialogs/dashboard-demo-dialog/dashboard-demo-dialog';

@Component({
  selector: 'app-dashboard',
  providers: [DialogService],
  imports: [
    Card,
    Knob,
    FormsModule,
    Carousel,
    Tag,
    Button,
    NgStyle
  ],
  templateUrl: './dashboard.html',
})
export class Dashboard implements OnInit {
  private dialogService: DialogService = inject(DialogService)
  private http: HttpClient = inject(HttpClient)
  private authService: AuthService = inject(AuthService);

  protected ref: DynamicDialogRef | undefined;

  showScoreInfoDialog() {
    this.ref = this.dialogService.open(ScoreInfoDialog, {
      header: 'Score - Info',
      width: '90vw',
      height: '180vw',
    });
  }

  protected products: any[] = [
    {
      id: '1000',
      pictureUrl: 'assets/soiree_accueil.jpg',
      name: 'Soirée d\'accueil',
      description: 'Product Description',
      image: 'bamboo-watch.jpg',
      date: '23/09',
      category: 'Soirée',
      inventoryStatus: 'Passée',
      severity: 'danger',
    },
    {
      id: '1001',
      pictureUrl: 'assets/bleusaille_accueil.jpg',
      name: 'Bleusaille d\'accueil',
      description: 'Product Description',
      image: 'bamboo-watch.jpg',
      date: '01/10',
      category: 'Bleusaille',
      inventoryStatus: 'Ce soir',
      severity: 'warn',
    },
    {
      id: '1002',
      pictureUrl: 'assets/parrainage.jpg',
      name: 'Parrainage',
      description: 'Product Description',
      image: 'bamboo-watch.jpg',
      date: '07/10',
      category: 'Bleusaille',
      inventoryStatus: 'A venir',
      severity: 'success',
    },
    {
      id: '1002',
      pictureUrl: 'assets/bleusaille_guerre.jpg',
      name: 'Bleusaille guerre',
      description: 'Product Description',
      image: 'bamboo-watch.jpg',
      date: '10/10',
      category: 'Bleusaille',
      inventoryStatus: 'A venir',
      severity: 'success',
    },
    {
      id: '1002',
      pictureUrl: 'assets/roi_des_bleus.jpg',
      name: 'Roi des bleus',
      description: 'Product Description',
      image: 'bamboo-watch.jpg',
      date: '15/10',
      category: 'Bleusaille',
      inventoryStatus: 'A venir',
      severity: 'success',
    },
  ];

  responsiveOptions: any[] | undefined;

  ngOnInit() {

    this.responsiveOptions = [
      {
        breakpoint: '1400px',
        numVisible: 2,
        numScroll: 1
      },
      {
        breakpoint: '1199px',
        numVisible: 3,
        numScroll: 1
      },
      {
        breakpoint: '767px',
        numVisible: 2,
        numScroll: 1
      },
      {
        breakpoint: '575px',
        numVisible: 1,
        numScroll: 1
      }
    ]
  }

  // getSeverity(status: string) {
  //   switch (status) {
  //     case 'INSTOCK':
  //       return 'success';
  //     case 'LOWSTOCK':
  //       return 'warn';
  //     case 'OUTOFSTOCK':
  //       return 'danger';
  //   }
  // }
  toggleDashboardDemoDialog() {
      this.ref = this.dialogService.open(DashboardDemoDialog, {
        header: 'Dashboard - Info',
        width: '90vw',
        height: '180vw',
      });
  }
}

