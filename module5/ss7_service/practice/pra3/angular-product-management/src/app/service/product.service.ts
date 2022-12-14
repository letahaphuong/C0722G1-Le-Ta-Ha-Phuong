import {Injectable} from '@angular/core';
import {Product} from "../model/product";
import {element} from "protractor";
import {Route, Router} from "@angular/router";

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  products: Product[] = [
    {
      id: 1,
      name: 'IPhone 12',
      price: 2400000,
      description: 'New'
    }, {
      id: 2,
      name: 'IPhone 11',
      price: 1560000,
      description: 'Like new'
    }, {
      id: 3,
      name: 'IPhone X',
      price: 968000,
      description: '97%'
    }, {
      id: 4,
      name: 'IPhone 8',
      price: 7540000,
      description: '98%'
    }, {
      id: 5,
      name: 'IPhone 11 Pro',
      price: 1895000,
      description: 'Like new'
    }
  ]

  constructor(private router: Router) {
  }

  getAll() {
    return this.products;
  }

  editProduct(id: number, product: Product) {
    for (let i = 0; i < this.products.length; i++) {
      if (this.products[i].id === id) {
        this.products[i] = product;
        console.log(this.products[i])
      }
    }
    // this.products.push(product);
    this.router.navigateByUrl("/product/list")
  }

  saveProduct(product: Product) {
    this.products.push(product)
  }

  // findByName(name: string): Product | null {
  //   let temp = this.products.filter(element => element.name === name);
  //   if (temp.length === 0) {
  //     return null;
  //   }
  //   return temp[0];
  // }

  findById(id: number): Product | null {
    let temp = this.products.filter(element => element.id === id);
    if (temp.length === 0) {
      return null;
    }
    return temp[0];
  }

  deleteById(id: number | undefined) {
    if (id != undefined) {
      let product = this.findById(id);
      if (product != null) {
        let length = this.products.length
        for (let i = 0; i < length; i++) {
          if (this.products[i].id == product.id) {
            this.products.splice(i, 1);
            break;
          }
        }
      }
    }
  }
}
