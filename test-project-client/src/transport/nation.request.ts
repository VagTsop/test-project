import { Paging } from "./helper/paging.helper";

export class NationRequest {

  private paging: Paging = new Paging();
  private countryId: number;
  private regionId: number;
  private dateFrom: Date;
  private dateTo: Date;

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

  /**
 * Getter $regionId
 * @return {number}
 */
  public get $regionId(): number {
    return this.regionId;
  }

  /**
   * Setter $regionId
   * @param {number[]} value
   */
  public set $regionId(value: number) {
    this.regionId = value;
  }


  /**
 * Getter $dateFrom
 * @return {Date}
 */
  public get $dateFrom(): Date {
    return this.dateFrom;
  }

  /**
   * Setter $dateFrom
   * @param {Date} value
   */
  public set $dateFrom(value: Date) {
    this.dateFrom = value;
  }

  /**
   * Getter $dateTo
   * @return {Date}
   */
  public get $dateTo(): Date {
    return this.dateTo;
  }

  /**
   * Setter $dateTo
   * @param {Date} value
   */
  public set $dateTo(value: Date) {
    this.dateTo = value;
  }
}
