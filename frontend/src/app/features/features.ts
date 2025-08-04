import {ChangeDetectionStrategy, Component} from '@angular/core';
import {RouterOutlet} from '@angular/router';
import {BaseLayoutPi} from './layout/base-layout-pi/base-layout-pi';

@Component({
  changeDetection: ChangeDetectionStrategy.OnPush,
  imports: [RouterOutlet, BaseLayoutPi],
  standalone: true,
  template: `
    <app-base-layout-pi>
      <router-outlet />
    </app-base-layout-pi>
  `
})
export class Features {}
