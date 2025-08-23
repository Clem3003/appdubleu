import { Component } from '@angular/core';
import {Skeleton} from 'primeng/skeleton';
import {NgIf} from '@angular/common';
import {Divider} from 'primeng/divider';
import {ButtonDirective} from 'primeng/button';
import {Card} from 'primeng/card';
import {Toolbar} from 'primeng/toolbar';
import {Tag} from 'primeng/tag';
import {OverlayBadge} from 'primeng/overlaybadge';
import {Avatar} from 'primeng/avatar';
import {Rating} from 'primeng/rating';
import {Badge} from 'primeng/badge';
import {FormsModule} from '@angular/forms';
import {ProgressBar} from 'primeng/progressbar';
import {TableModule} from 'primeng/table';
import {Chip} from 'primeng/chip';

@Component({
  selector: 'app-bleu-info',
  imports: [
    Skeleton,
    NgIf,
    Divider,
    ButtonDirective,
    Card,
    Toolbar,
    Tag,
    OverlayBadge,
    Avatar,
    Rating,
    Badge,
    FormsModule,
    ProgressBar,
    TableModule,
    Chip
  ],
  templateUrl: './bleu-info.html'
})
export class BleuInfo {
  maxStars: number = 5;
  redValue: number = 2;
  greenValue: number = 0;

}
