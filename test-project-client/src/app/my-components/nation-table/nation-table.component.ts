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
    this.req.$paging.$pageSize = 10;
  }

  ngOnInit(): void {
    this.subscriptions.add(this.nationService.fetchRegions().subscribe((data) => {
      this.regionList = data;
      this.filteredRegionList = data;
    }));
    this.onList()
  }

  onList(): void {
    this.subscriptions.add(this.nationService.getNationTableData(this.req)
      .subscribe(res => {
        this.modelList = res.content;
        this.size = this.modelList.length;
        this.req.$paging.$totalSize = res.totalElements;
      }));
  }

  onSearch() {
    this.onList();
  }

  onReset() {
    this.filteredRegionList = this.regionList;
    this.req = new NationRequest();
    this.req.$paging.$orderField = Field.CONTINENT_NAME;
    this.onList();
  }

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
