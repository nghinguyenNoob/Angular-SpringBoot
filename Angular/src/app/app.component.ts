import { Component, OnInit } from '@angular/core';
import { Router, NavigationEnd } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'angular-employee';

  constructor(router: Router) {
    // router refresh when click
    router.routeReuseStrategy.shouldReuseRoute = function() {
      return false;
    };
    router.events.subscribe((evt) => {
      if (evt instanceof NavigationEnd) {
        router.navigated = false;
        window.scrollTo(0, 0);
      }
    });
  }
}
