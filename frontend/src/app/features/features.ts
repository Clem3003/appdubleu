import {ChangeDetectionStrategy, Component} from '@angular/core';
import {RouterOutlet} from '@angular/router';
import {BaseLayoutPi} from './layout/base-layout-pi/base-layout-pi';
import {BaseLayoutFaBlue} from './layout/base-layout-fa-blue/base-layout-fa-blue';

@Component({
  changeDetection: ChangeDetectionStrategy.OnPush,
  imports: [RouterOutlet, BaseLayoutFaBlue],
  standalone: true,
  template: `
    <app-base-layout-fa-blue>
      <router-outlet />
    </app-base-layout-fa-blue>
  `
})
export class Features {}
