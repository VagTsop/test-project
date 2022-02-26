import { NgModule } from '@angular/core';
import { AppComponent } from './app.component';
import { HeaderComponent } from './my-components/header/header.component';
import { ListComponent } from './my-components/list/list.component';
import { SharedModule } from './shared.module';
@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    ListComponent,
  ],
  imports: [
    SharedModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
