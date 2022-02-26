import { Component, OnDestroy, OnInit } from '@angular/core';
import { GenericComponent } from '../generic.component';
import { NationService } from 'src/services/nation.service';
import { NationRequest } from 'src/transport/nation.request';
import { Field } from 'src/transport/helper/table-fields.helper';


@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  providers: [NationService]
})
export class ListComponent extends GenericComponent implements OnInit, OnDestroy {


  constructor(
    private nationService: NationService
  ) {
    super();
    this.req.$paging.$pageSize = 20;
  }

  ngOnInit(): void {
    this.onList();
  }

  onList(): void {
    this.subscriptions.add(this.nationService.getList(this.req)
      .subscribe(res => {
        this.modelList = res.content;
        this.req.$paging.$totalSize = res.totalElements;
      }));
  }

  ngOnDestroy() {
    this.subscriptions.unsubscribe();
  }

  onChangePaging(changePaging: any): void {
    this.req.$paging = changePaging;
    this.onList();
  }
}
