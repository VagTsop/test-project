import { DatePipe } from '@angular/common';
import { Component, OnDestroy, OnInit } from '@angular/core';
import { NationService } from 'src/services/nation.service';
import { Field } from 'src/transport/helper/table-fields.helper';
import { NationRequest } from 'src/transport/nation.request';
import { GenericComponent } from '../generic.component';

@Component({
  selector: 'app-nation-table',
  templateUrl: './nation-table.component.html',
  providers: [NationService]
})
export class NationTableComponent extends GenericComponent implements OnInit, OnDestroy {
  filterOpened = false;

  regionList: any = [];
  filteredRegionList: any = [];
  dateFrom: Date;
  dateTo: Date;
  maxDate: Date;
  minDateFrom: Date;

  size: number;

  constructor(
    private nationService: NationService,
    public datePipe: DatePipe
  ) {
    super();
  }

  ngOnInit(): void {
    this.subscriptions.add(this.nationService.fetchRegions().subscribe((data) => {
      this.regionList = data;
      this.filteredRegionList = data;
    }));
  }

  onList(): void {
    this.subscriptions.add(this.nationService.getList(this.req)
      .subscribe(res => {
        this.modelList = res.content;
        this.size = this.modelList.length;
      }));
  }

  onSearch() {
    // this.req.$dateFrom = this.datePipe.transform(this.dateFrom, 'yyyy-MM-dd');
    // this.req.$dateTo = this.datePipe.transform(this.dateTo, 'yyyy-MM-dd');
    this.onList();
  }

  onReset() {
    this.filteredRegionList = this.regionList;
    this.req = new NationRequest();
    this.req.$paging.$orderField = Field.CONTINENT_NAME;
    // this.dateFrom = new Date();
    // this.dateTo = new Date();
    // this.req.$dateFrom = this.datePipe.transform(this.dateFrom, 'yyyy-MM-dd');
    // this.req.$dateTo = this.datePipe.transform(this.dateTo, 'yyyy-MM-dd');
    // this.dateFromMax = this.req.$dateTo;
    // this.dateToMin = this.req.$dateFrom;



    // for the first time, the maximum time allowed to view events is one month
    // const day = new Date();
    // day.setFullYear(this.dateFrom.getFullYear());
    // day.setMonth(this.dateFrom.getMonth());
    // day.setDate(this.dateFrom.getDate());
    // this.dateTo = null;
    this.onList();
  }

  // getDate(event) {
  //   let chosenDate = null;
  //   try {
  //     if (event.value) {
  //       chosenDate = event.value;
  //     } else if (event.target.value) {
  //       const dateArray = event.target.value.split('/');
  //       // chosenDate = new Date(dateArray[2] + '-' + dateArray[1] + '-' + dateArray[0]);
  //     }
  //     chosenDate = this.datePipe.transform(chosenDate, 'yyyy-MM-dd');
  //   } catch (error) {
  //     // console.error(error);
  //   }
  //   return chosenDate;
  // }


  onDatePicker(event: any) {
    this.dateTo = null as any;
    if (event != null && this.dateFrom === null) {
      const tempDay = new Date();
      tempDay.setFullYear(event.getFullYear());
      tempDay.setMonth(event.getMonth());
      tempDay.setDate(event.getDate());
      this.minDateFrom = new Date(
        tempDay.setMonth(tempDay.getMonth() - 1)
      );
    }
  }


  filterTypeList(search: any) {
    this.filteredRegionList = this.regionList.filter((item: any) => item.regionName.toLowerCase().includes(search.toLowerCase().toString()));
  }

  onChangePaging(changePaging: any): void {
    this.req.$paging = changePaging;
    this.onList();
  }

  ngOnDestroy() {
    this.subscriptions.unsubscribe();
  }
}
