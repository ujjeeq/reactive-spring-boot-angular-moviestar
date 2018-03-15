import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { MatButtonModule, MatCardModule, MatInputModule, MatListModule, MatToolbarModule } from '@angular/material';



import { AppComponent } from './app.component';
import {HttpClientModule} from '@angular/common/http';
import { StarListComponent } from './star-list/star-list.component';
import {StarService} from "./shared/star/star.service";
import {TmdbService} from "./shared/tmdb/tmdb.service";


@NgModule({
  declarations: [
    AppComponent,
    StarListComponent,

  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    MatButtonModule,
    MatCardModule,
    MatInputModule,
    MatListModule,
    MatToolbarModule
  ],
  providers: [StarService,TmdbService],
  bootstrap: [AppComponent]
})
export class AppModule { }
