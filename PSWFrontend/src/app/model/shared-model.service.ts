import { Injectable } from '@angular/core';
import { RestManager } from './managers/RestManager';
import { HttpClient } from '@angular/common/http';
import { ADDRESS_SPRING_SERVER } from './support/Constants'
import { REQUEST_GETALLPRODUCT, REQUEST_GETPRODUCTBYNAME } from './support/Constants'

@Injectable({
  providedIn: 'root'
})
export class SharedModelService {
  restManager: RestManager;

  constructor(http: HttpClient) {
    this.restManager = new RestManager(http);
  }

  getProductByName(name: string, callback: any) {
    this.restManager.makeGetRequest(ADDRESS_SPRING_SERVER, REQUEST_GETPRODUCTBYNAME, { name: name }, callback);
  }

  getAllProduct(callback: any) {
    this.restManager.makeGetRequest(ADDRESS_SPRING_SERVER, REQUEST_GETALLPRODUCT, {}, callback);
  }
}
