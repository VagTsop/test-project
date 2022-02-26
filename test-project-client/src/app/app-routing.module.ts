import { NgModule } from "@angular/core";
import { RouterModule, Routes } from "@angular/router";
import { LanguagesSpokenComponent } from "./my-components/languages-spoken/languages-spoken.component";
import { ListComponent } from "./my-components/list/list.component";
import { MenuComponent } from "./my-components/menu/menu.component";

const routes: Routes = [
  {
    path: '', component: MenuComponent,

  },
  {
    path: 'menu/task1',
    component: ListComponent
  },
  {
    path: 'menu/task1/:countryId',
    component: LanguagesSpokenComponent
  }
]
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
