import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { MenuComponent } from './my-components/menu/menu.component';
import { SharedModule } from './shared.module';
import { LanguagesSpokenComponent } from './my-components/languages-spoken/languages-spoken.component';
import { NationTableListComponent } from './my-components/nation-table-list/nation-table-list.component';
import {DatePipe} from '@angular/common';
import { CountryListComponent } from './my-components/country-list/country-list';

@NgModule({
  declarations: [
    AppComponent,
    CountryListComponent,
    MenuComponent,
    LanguagesSpokenComponent,
    NationTableListComponent
  ],
  imports: [
    SharedModule,
    AppRoutingModule
  ],
  providers: [
    DatePipe,
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
