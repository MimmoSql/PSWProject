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

@Component({
  selector: 'foo-ter',
  templateUrl: './app.footer.html',
  styleUrls: ['./app.component.css']
})
export class FooTer {
  title = 'PSWFrontend';
}

@Component({
  selector: 'button-login',
  templateUrl: './app.loginButton.html',
  styleUrls: ['./app.component.css']
})
export class LoginButton {
  title = 'PSWFrontend';
}

@Component({
  selector: 'button-trolley',
  templateUrl: './app.trolleyButton.html',
  styleUrls: ['./app.component.css']
})
export class TrolleyButton {
  title = 'PSWFrontend';
}