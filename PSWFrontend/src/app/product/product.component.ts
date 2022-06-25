import { Component, OnInit } from '@angular/core';
import { FormControl } from '@angular/forms';
import { SharedModelService } from '../model/shared-model.service';
import { Product } from '../model/objects/Product';


@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent {
  title = 'PSWFrontend';
  model: SharedModelService;
  searchController = new FormControl();
  productName = new FormControl();
  productPrice = new FormControl();
  productQuantity = new FormControl();
  searchResult : Product[] = [];
  searchStatus=true;
  addResult: Product[] = [];
  addStatus=true;

  constructor(model: SharedModelService) {
    this.model = model;
  }

  searchProduct(){
    if(this.searchController.value == null){ 
      this.model.getAllProduct(this.showResultProduct.bind(this))
    }
    else{ 
      this.model.getProductByName(this.searchController.value, this.showResultProduct.bind(this))
    }
  }

  showResultProduct(status: boolean, response: any){
    this.searchStatus = status;
    if(status){
      this.searchResult = response as Product[];
    }
  }
}
