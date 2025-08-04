import { Component } from '@angular/core';
import {NgClass, NgOptimizedImage} from '@angular/common';
import {Router, RouterLink} from "@angular/router";

@Component({
  selector: 'app-base-layout',
    imports: [
        RouterLink,
        NgClass
    ],
  templateUrl: './base-layout.html',
})
export class BaseLayout {
    constructor(private router: Router) {}

    isActive(url: string): boolean {
        console.log(this.router.url + "===" + url);
        console.log(this.router.url === url);
        return this.router.url === url;
    }
}
