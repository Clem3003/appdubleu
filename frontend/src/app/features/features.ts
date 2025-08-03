import { ChangeDetectionStrategy, Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import {BaseLayout} from './layout/base-layout/base-layout';

@Component({
  changeDetection: ChangeDetectionStrategy.OnPush,
  imports: [RouterOutlet, BaseLayout],
  standalone: true,
  template: `
    <app-base-layout>
      <router-outlet />
    </app-base-layout>
  `
})
export class Features {}
