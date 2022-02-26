import { Paging } from "./helper/paging.helper";

export class NationRequest {

  private paging: Paging = new Paging();
  private countryId: number;


  /**
   * Getter $paging
   * @return {Paging }
   */
  public get $paging(): Paging {
    return this.paging;
  }

  /**
   * Setter $paging
   * @param {Paging } value
   */
  public set $paging(value: Paging) {
    this.paging = value;
  }


  /**
   * Getter $countryId
   * @return {number}
   */
  public get $countryId(): number {
    return this.countryId
  }

  /**
   * Setter $countryId
   * @param {number} value
   */
  public set $countryId(value: number) {
    this.countryId = value;
  }
}
