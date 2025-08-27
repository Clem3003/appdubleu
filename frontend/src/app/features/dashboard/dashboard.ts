import {Component, inject, OnDestroy, OnInit, signal} from '@angular/core';
import {Card} from 'primeng/card';
import {Knob} from 'primeng/knob';
import {FormsModule} from '@angular/forms';
import {DialogService, DynamicDialogRef} from 'primeng/dynamicdialog';
import {ScoreInfoDialog} from './score-info-dialog/score-info-dialog';
import {Carousel} from 'primeng/carousel';
import {Tag} from 'primeng/tag';
import {Button} from 'primeng/button';
import {NgStyle} from '@angular/common';
import {HttpClient} from '@angular/common/http';
import {AuthService} from '../../user/login/auth/auth.service';
import {Avatar} from 'primeng/avatar';
import {Divider} from 'primeng/divider';
import {StLoBleu, StLoUser} from '../../user/login/login.model';

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
    NgStyle,
    Avatar,
    Divider
  ],
  templateUrl: './dashboard.html',
})
export class Dashboard implements OnInit, OnDestroy {
  protected authService: AuthService = inject(AuthService)
  private dialogService: DialogService = inject(DialogService)
  private http: HttpClient = inject(HttpClient)

  protected ref: DynamicDialogRef | undefined;
  private intervalId: any;

  // signal pour stocker le temps restant (sous forme HH:mm:ss)
  timeLeft = signal(this.computeTimeLeft());

  showScoreInfoDialog() {
    this.ref = this.dialogService.open(ScoreInfoDialog, {
      header: 'Score - Info',
      width: '90vw',
      height: '180vw',
    });
  }

  protected bests: StLoBleu[] = [

  ]
  protected targets: StLoBleu[] = [
    {
      id: '',
      username: 'wensel.matthéo',
      lastname: 'Wensel',
      nickname: ''
    },
    {
      id: '',
      username: '',
      lastname: 'Wilmart',
      nickname: ''
    },
    {
      id: '',
      username: '',
      lastname: 'Paquay',
      nickname: ''
    },
    {
      id: '',
      username: '',
      lastname: 'Nyckees',
      nickname: ''
    },
  ]
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

    // met à jour chaque seconde
    this.intervalId = setInterval(() => {
      this.timeLeft.set(this.computeTimeLeft());
    }, 1000);

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

  ngOnDestroy() {
    clearInterval(this.intervalId);
  }

  private computeTimeLeft(): string {
    const now = new Date();
    const midnight = new Date();
    midnight.setHours(24, 0, 0, 0); // minuit prochain

    const diff = midnight.getTime() - now.getTime();

    const hours = Math.floor(diff / (1000 * 60 * 60));
    const minutes = Math.floor((diff % (1000 * 60 * 60)) / (1000 * 60));
    const seconds = Math.floor((diff % (1000 * 60)) / 1000);

    return `${this.pad(hours)}:${this.pad(minutes)}:${this.pad(seconds)}`;
  }

  private pad(n: number): string {
    return n.toString().padStart(2, '0');
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
}

