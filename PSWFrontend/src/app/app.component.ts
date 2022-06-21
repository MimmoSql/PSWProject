import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'PSWFrontend';
}

@Component({
  selector: 'nav-bar',
  templateUrl: './app.navbar.html',
  styleUrls: ['./app.component.css']
})
export class NavBar {
  title = 'PSWFrontend';
}