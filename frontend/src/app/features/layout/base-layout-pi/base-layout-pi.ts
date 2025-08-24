import {ChangeDetectorRef, Component, computed, inject, OnInit, signal} from '@angular/core';
import {NavigationEnd, Router, RouterLink} from '@angular/router';
import {filter} from 'rxjs';
import {dom} from '@fortawesome/fontawesome-svg-core';
import {NgClass} from '@angular/common';
import {Menu} from 'primeng/menu';
import {MenuItem} from 'primeng/api';
import {AuthService} from '../../../user/login/auth/auth.service';
import {DialogService, DynamicDialogRef} from 'primeng/dynamicdialog';
import {DemoDialog} from '../demo-dialogs/demo-dialog/demo-dialog';

@Component({
  selector: 'app-base-layout-pi',
  imports: [
    NgClass,
    RouterLink,
    Menu
  ],
  providers: [DialogService],
  templateUrl: './base-layout-pi.html'
})
export class BaseLayoutPi implements  OnInit {
  private readonly router = inject(Router);
  private readonly authService = inject(AuthService);
  private readonly cd = inject(ChangeDetectorRef);
  protected ref: DynamicDialogRef | undefined;
  private dialogService: DialogService = inject(DialogService)
  protected readonly accountMenuItems: MenuItem[] = [
    {
      label: 'Profile',
      items: [
        {
          label: 'Profile',
          icon: 'pi pi-user',
          command: () => this.router.navigate(['/profile'], {queryParams: {}})
        },
        {
          label: 'Edit profile',
          icon: 'pi pi-user-edit',
          command: () => this.router.navigate(['/profile/edit'], {queryParams: {}})
        },
        {
          label: 'Settings',
          icon: 'pi pi-cog',
          command: () => this.router.navigate(['/profile'], {queryParams: {}})
        },
        {
          label: 'Me',
          icon: 'pi pi-globe',
          command: () => this.authService.me().subscribe()
        },
        {
          label: 'Logout',
          icon: 'pi pi-sign-out',
          command: () => this.authService.logout().subscribe()
        }
      ]
    },
    {
      label: 'Informations',
      items: [
        {
          label: 'Infos',
          icon: 'pi pi-info-circle'
        }
      ]
    }
  ];

  // faHouseSolid = faHouseSolid;
  // faHouseRegular = faHouseRegular;

  // Signal de route courante
  protected readonly currentPage = signal(this.router.url);

  ngOnInit(): void {
    this.router.events
      .pipe(filter(event => event instanceof NavigationEnd))
      .subscribe((event: NavigationEnd) => {
        this.currentPage.set(event.urlAfterRedirects);
        dom.i2svg();
      });
  }


  // Signaux pour chaque icône
  protected readonly homeSelected = computed(() =>
    this.currentPage() === '/dashboard'
  );
  protected readonly folkloreSelected = computed(() =>
    this.currentPage() === '/folklore'
  );
  protected readonly forumSelected = computed(() =>
    this.currentPage() === '/forum'
  );
  protected readonly profileSelected = computed(() =>
    this.currentPage() === '/account'
  );

  protected readonly homeIconType = computed(() =>
    this.currentPage() === '/dashboard' ? 'fa-solid' : 'fa-regular'
  );

  protected readonly folkloreIconType = computed(() =>
    this.currentPage() === '/folklore' ? 'fa-solid' : 'fa-regular'
  );

  protected readonly forumIconType = computed(() =>
    this.currentPage() === '/forum' ? 'fa-solid' : 'fa-regular'
  );

  protected readonly profileIconType = computed(() =>
    this.currentPage() === '/profile' ? 'fa-solid' : 'fa-regular'
  );

  toggleDemoDialog() {
    this.ref = this.dialogService.open(DemoDialog, {
          header: 'Demo - Info',
          width: '90vw',
          height: '180vw',
        });
    // if (this.currentPage() === '/dashboard' || this.currentPage() === '/'){
    //   this.ref = this.dialogService.open(DashboardDemoDialog, {
    //     header: 'Dashboard - Info',
    //     width: '90vw',
    //     height: '180vw',
    //   });
    // }
    // if (this.currentPage() === '/folklore'){
    //   this.ref = this.dialogService.open(FolkloreDemoDialog, {
    //     header: 'Folklore - Info',
    //     width: '90vw',
    //     height: '180vw',
    //   });
    // }
    // if (this.currentPage() === '/forum'){
    //   this.ref = this.dialogService.open(MessageDemoDialog, {
    //     header: 'Forum - Info',
    //     width: '90vw',
    //     height: '180vw',
    //   });
    // }
    // if (this.currentPage() === '/profile'){
    //   this.ref = this.dialogService.open(CompteDemoDialog, {
    //     header: 'Profile - Info',
    //     width: '90vw',
    //     height: '180vw',
    //   });
    // }
  }
}
