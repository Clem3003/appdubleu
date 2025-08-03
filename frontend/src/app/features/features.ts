import { ChangeDetectionStrategy, Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';

@Component({
  changeDetection: ChangeDetectionStrategy.OnPush,
  imports: [RouterOutlet],
  standalone: true,
  template: `
    <!-- In the draft folder you will find 3 layout examples. Change the number: app-layout-example-{number} -->
<!--    <app-layout>-->
      <router-outlet />
<!--    </app-layout>-->
  `
})
export class Features {}
