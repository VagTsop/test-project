import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './my-components/header/header.component';
import { ListComponent } from './my-components/list/list.component';
import { MenuComponent } from './my-components/menu/menu.component';
import { SharedModule } from './shared.module';
import { LanguagesSpokenComponent } from './my-components/languages-spoken/languages-spoken.component';
import { NationTableComponent } from './my-components/nation-table/nation-table.component';
import {DatePipe} from '@angular/common';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    ListComponent,
    MenuComponent,
    LanguagesSpokenComponent,
    NationTableComponent
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
