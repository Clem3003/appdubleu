import {ChangeDetectorRef, Component, computed, inject, OnInit, signal} from '@angular/core';
import {NavigationEnd, Router, RouterLink} from '@angular/router';
import {filter} from 'rxjs';
import {dom} from '@fortawesome/fontawesome-svg-core';
import {NgClass} from '@angular/common';

@Component({
  selector: 'app-base-layout-pi',
  imports: [
    NgClass,
    RouterLink
  ],
  templateUrl: './base-layout-pi.html'
})
export class BaseLayoutPi implements  OnInit {
  private readonly router = inject(Router);
  private readonly cd = inject(ChangeDetectorRef);

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
    this.currentPage() === '/profile'
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
}
