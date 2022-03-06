import { Component, OnDestroy, OnInit } from '@angular/core';
import { GenericComponent } from '../generic.component';
import { NationService } from 'src/services/nation.service';
import { ActivatedRoute, Router } from '@angular/router';


@Component({
  selector: 'app-country-list',
  templateUrl: './country-list.component.html',
  providers: [NationService]
})
export class CountryListComponent extends GenericComponent implements OnInit, OnDestroy {

  constructor(
    public route: ActivatedRoute,
    public router: Router,
    private nationService: NationService
  ) {
    super();
    this.req.$paging.$pageSize = 20;
  }

  ngOnInit(): void {
    this.onList();
  }

  onList(): void {
    this.subscriptions.add(this.nationService.getCountriesList(this.req)
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

  onDisplayLanguagesSpokenByCountry(item: any): void {
    this.router.navigateByUrl(`menu/task1/${item}`);
  }
}
