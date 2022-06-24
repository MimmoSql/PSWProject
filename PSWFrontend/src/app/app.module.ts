import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent, NavBar, FooTer,LoginButton,TrolleyButton} from './app.component';
import { SocialComponent } from './social/social.component';
import { RouterModule } from '@angular/router';
import { ProductComponent } from './product/product.component';
import { TrolleyComponent } from './trolley/trolley.component';
import { LoginComponent } from './login/login.component';

@NgModule({
  declarations: [
    AppComponent,
    NavBar,
    FooTer,
    LoginButton,
    TrolleyButton,
    SocialComponent,
    ProductComponent,
    TrolleyComponent,
    LoginComponent,

  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    RouterModule.forRoot([
      { path: 'social', component: SocialComponent },
      { path: 'product', component: ProductComponent },
      { path: 'trolley', component: TrolleyComponent },
      { path: 'login', component: LoginComponent }
    ])
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }


