import { Paging } from "./helper/paging.helper";

export class NationRequest {

  private paging: Paging = new Paging();
  private regionId: number;
  private yearFrom: string;
  private yearTo: string;
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
 * @return {string}
 */
  public get $yearFrom(): string {
    return this.yearFrom;
  }

  /**
   * Setter $yearFrom
   * @param {string} value
   */
  public set $yearFrom(value: string) {
    this.yearFrom = value;
  }

  /**
   * Getter $yearTo
   * @return {string}
   */
  public get $yearTo(): string {
    return this.yearTo;
  }

  /**
   * Setter $yearTo
   * @param {string} value
   */
  public set $yearTo(value: string) {
    this.yearTo = value;
  }
}
