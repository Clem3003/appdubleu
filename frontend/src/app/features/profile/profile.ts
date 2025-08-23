import {Component, inject, OnInit} from '@angular/core';
import {TableModule} from 'primeng/table';
import {Avatar} from 'primeng/avatar';
import {ButtonDirective, ButtonIcon, ButtonLabel} from 'primeng/button';
import {Card} from 'primeng/card';
import {Divider} from 'primeng/divider';
import {AuthService} from '../../user/login/auth/auth.service';
import {NgForOf} from '@angular/common';
import {Rating} from 'primeng/rating';
import {Tag} from 'primeng/tag';

@Component({
  selector: 'app-profile',
  imports: [
    TableModule,
    Avatar,
    ButtonDirective,
    ButtonIcon,
    ButtonLabel,
    Card,
    Divider,
    NgForOf,
    Rating,
    Tag
  ],
  templateUrl: './profile.html'
})
export class Profile implements OnInit {
    protected authService: AuthService = inject(AuthService)

    ngOnInit(): void {

    }

}
