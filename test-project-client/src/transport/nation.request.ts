import { Paging } from "./helper/paging.helper";

export class NationRequest {

  private countryId: number;
  private countryName: string;
  private area: number;
  private countryCode2: string;
  private dateFrom: Date;
  private dateTo: Date;


  private paging: Paging = new Paging();

  /**
     * Getter $countryId
     * @return {number}
     */
  public get $countryId(): number {
    return this.countryId;
  }

  /**
   * Setter $countryId
   * @param {number} value
   */
  public set $countryId(value: number) {
    this.countryId = value;
  }

  /**
   * Getter $countryName
   * @return {string}
   */
  public get $countryName(): string {
    return this.countryName;
  }

  /**
   * Setter $countryName
   * @param {string} value
   */
  public set $countryName(value: string) {
    this.countryName = value;
  }

  /**
 * Getter $area
 * @return {number}
 */
  public get $area(): number {
    return this.area;
  }

  /**
   * Setter $area
   * @param {number} value
   */
  public set $area(value: number) {
    this.area = value;
  }

  /**
   * Setter $countryCode2
   * @param {string} value
   */
  public set $countryCode2(value: string) {
    this.countryCode2 = value;
  }

  /**
   * Getter $countryCode2
   * @return {string}
   */
  public get $countryCode2(): string {
    return this.countryCode2;
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


}
