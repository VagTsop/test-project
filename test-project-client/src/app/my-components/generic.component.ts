import { Component, OnInit } from '@angular/core';
import { Subscription } from 'rxjs';
import { NationRequest } from 'src/transport/nation.request';

@Component({
  template: ''
})

export class GenericComponent{

  constructor() { }

  modelList: any = [];
  subscriptions: Subscription = new Subscription();
  req = new NationRequest();
}
