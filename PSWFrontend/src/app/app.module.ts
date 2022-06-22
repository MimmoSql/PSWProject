import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent, NavBar, FooTer,LoginButton,TrolleyButton} from './app.component';
import { SocialComponent } from './social/social.component';
import { RouterModule } from '@angular/router';
import { ProductComponent } from './product/product.component';

@NgModule({
  declarations: [
    AppComponent,
    NavBar,
    FooTer,
    LoginButton,
    TrolleyButton,
    SocialComponent,
    ProductComponent
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot([
      { path: 'social', component: SocialComponent },
      { path: 'product', component: ProductComponent }
    ])
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }


