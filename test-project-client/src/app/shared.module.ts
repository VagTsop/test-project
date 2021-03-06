import { CommonModule } from "@angular/common";
import { HttpClientModule } from "@angular/common/http";
import { NgModule } from "@angular/core";
import { FlexLayoutModule } from "@angular/flex-layout";
import { FormsModule, ReactiveFormsModule } from "@angular/forms";
import { MatButtonModule } from "@angular/material/button";
import { MatCardModule } from "@angular/material/card";
import { MatFormFieldModule } from "@angular/material/form-field";
import { MatIconModule } from "@angular/material/icon";
import { MatInputModule } from "@angular/material/input";
import { MatMenuModule } from "@angular/material/menu";
import { MatTooltipModule } from "@angular/material/tooltip";
import { BrowserModule } from "@angular/platform-browser";
import { BrowserAnimationsModule } from "@angular/platform-browser/animations";
import { PagingComponent } from "./my-components/paging/paging.component";
import { SortingComponent } from "./my-components/sorting/sorting.component";
import {MatDatepickerModule} from '@angular/material/datepicker';
import {MatSelectModule} from '@angular/material/select';

import {NgxMatSelectSearchModule} from 'ngx-mat-select-search';
import { MatNativeDateModule } from "@angular/material/core";

const MATERIAL_MODULES = [
  MatIconModule,
  MatButtonModule,
  MatMenuModule,
  MatCardModule,
  MatFormFieldModule,
  MatInputModule,
  MatTooltipModule,
  MatDatepickerModule,
  MatNativeDateModule ,
  MatSelectModule,
  NgxMatSelectSearchModule
];

@NgModule({

  declarations: [
    PagingComponent,
    SortingComponent,
  ],
  imports: [
    FlexLayoutModule,
    BrowserModule,
    FormsModule,
    HttpClientModule,
    CommonModule,
    ReactiveFormsModule,
    HttpClientModule,
    BrowserAnimationsModule,
    MATERIAL_MODULES,
  ],
  exports: [
    FormsModule,
    FlexLayoutModule,
    MATERIAL_MODULES,
    ReactiveFormsModule,
    CommonModule,
    PagingComponent,
    SortingComponent,
  ],
  providers: [
  ],
})
export class SharedModule {
}
