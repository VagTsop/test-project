import { NgModule } from "@angular/core";
import { RouterModule, Routes } from "@angular/router";
import { LanguagesSpokenComponent } from "./my-components/languages-spoken/languages-spoken.component";
import { CountryListComponent } from "./my-components/country-list/country-list";
import { MenuComponent } from "./my-components/menu/menu.component";
import { NationTableListComponent } from "./my-components/nation-table-list/nation-table-list.component";

const routes: Routes = [
  {
    path: '', component: MenuComponent,

  },
  {
    path: 'menu/task1',
    component: CountryListComponent
  },
  {
    path: 'menu/task1/:countryId',
    component: LanguagesSpokenComponent
  },
  {
    path: 'menu/task3',
    component: NationTableListComponent
  },

]
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
