import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';


import { ReactiveFormsModule } from '@angular/forms';

import { MatDatepickerModule } from '@angular/material/datepicker';

import { NoopAnimationsModule } from '@angular/platform-browser/animations';
import { MatSliderModule } from '@angular/material/slider';
import { MatProgressSpinnerModule } from '@angular/material/progress-spinner';
import { MatDividerModule } from '@angular/material/divider';
import { MatSnackBarModule } from '@angular/material/snack-bar';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatIconModule } from '@angular/material/icon';
import { MatNativeDateModule } from '@angular/material/core';
import { MatSelectModule } from '@angular/material/select';


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
    NoopAnimationsModule,
    HttpClientModule,
    ReactiveFormsModule,
    MatDatepickerModule,
    MatSliderModule,
    MatProgressSpinnerModule,
    MatSelectModule,
    MatNativeDateModule,
    MatIconModule,
    MatToolbarModule,
    MatSnackBarModule,
    MatDividerModule,
    
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


