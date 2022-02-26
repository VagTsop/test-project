import { Component, OnDestroy, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { NationService } from 'src/services/nation.service';
import { GenericComponent } from '../generic.component';

@Component({
  selector: 'app-languages-spoken',
  templateUrl: './languages-spoken.component.html',
  providers: [NationService]
})
export class LanguagesSpokenComponent extends GenericComponent implements OnInit, OnDestroy {

  private countryId = 0;
  constructor(
    private activatedRoute: ActivatedRoute,
    private nationService: NationService
  ) {
    super();
  }

  ngOnInit(): void {

    this.subscriptions.add(this.activatedRoute.params
      .subscribe(params => {
        this.countryId = params['countryId']
        console.log(this.countryId);
        this.subscriptions.add(this.nationService.fetchLanguagesSpokenByCountry(this.countryId)
          .subscribe(res => {
            this.modelList = res.content;
            this.req.$paging.$totalSize = res.totalElements;
          }));
      })
    );
  }

  ngOnDestroy() {
    this.subscriptions.unsubscribe();
  }
}
