import { HttpClient } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './my-components/header/header.component';
import { ListComponent } from './my-components/list/list.component';
import { MenuComponent } from './my-components/menu/menu.component';
import { SharedModule } from './shared.module';
@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    ListComponent,
    MenuComponent
  ],
  imports: [
    SharedModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
