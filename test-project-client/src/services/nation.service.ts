import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { Injectable } from '@angular/core';
import { NationRequest } from "src/transport/nation.request";
import { HttpClient, HttpParams } from "@angular/common/http";

@Injectable()
export class NationService {
  constructor(protected http: HttpClient) {
  }

  private basePath = 'http://localhost:8080/api/nation'

  getCountriesList(request: NationRequest): Observable<any> {
    return this.http.get(
      this.basePath + '/get-countries-list',
      {
        params: this.constructParams(request, null)
      }
    ).pipe(map((response: any) => {
      return response;
    }));
  }

  fetchLanguagesSpokenByCountry(countryId: number): Observable<any> {
    return this.http
      .get(this.basePath + '/fetch-languages-spoken-by-country', {
        params: new HttpParams().set('countryId', countryId.toString()),
      })
      .pipe(
        map((response: any) => {
          return response;
        })
      );
  }

  fetchRegions(): Observable<any> {
    return this.http
      .get(this.basePath + '/fetch-regions')
      .pipe(
        map((response: any) => {
          return response;
        })
      );
  }

  getNationList(request: NationRequest) {
    return this.http.get(
      this.basePath + '/get-nation-list',
      {
        params: this.constructParams(request, 'regionId,yearFrom,yearTo')
      }
    ).pipe(map((response: any) => {
      return response;
    }));
  }

  public constructParams(
    req: NationRequest,
    searchKeys: any
  ): HttpParams {

    let params: HttpParams = new HttpParams();
    // paging params
    params = params.append('page', (req.$paging.$pageNumber - 1).toString());
    params = params.append('size', req.$paging.$pageSize.toString());
    params = params.append(
      'sort',
      req.$paging.$orderField + ',' + req.$paging.$orderDirection
    );

    // search params
    if (searchKeys) {
      searchKeys.split(',').forEach((key) => {
        if (req[key] != null) {
          params = params.append(key, req[key]);
        }
      });
    }
    return params;
  }
}
