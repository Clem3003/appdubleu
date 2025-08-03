import { Component } from '@angular/core';
import {NgClass, NgOptimizedImage} from '@angular/common';
import {Router, RouterLinkActive} from "@angular/router";

@Component({
  selector: 'app-base-layout',
    imports: [
        NgClass,
        RouterLinkActive
    ],
  templateUrl: './base-layout.html',
})
export class BaseLayout {
    constructor(private router: Router) {}

    isActive(url: string): boolean {
        return this.router.url === url;
    }
}
