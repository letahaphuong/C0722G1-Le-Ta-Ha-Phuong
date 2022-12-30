import {Injectable} from '@angular/core';
import {Product} from "../model/product";
import {element} from "protractor";
import {Route, Router} from "@angular/router";
import {HttpClient} from "@angular/common/http";
import {Category} from "../model/category";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  API_URL = "http://localhost:3000/product";
  products: Product[] = [];

  constructor(private router: Router,
              private http: HttpClient) {
  }

  getAll() {
    return this.http.get<Product[]>(this.API_URL);
  }

  editProduct(id: number, product: Product) {
    return this.http.patch<Product>(this.API_URL + '/' + id, product)
  }

  saveProduct(product: Product): Observable<Product> {
    return this.http.post<Product>(this.API_URL, product);
  }

  findById(id: number): Observable<Product> {
    return this.http.get<Product>(this.API_URL + '/' + id);
  }

  deleteById(id: number | undefined): Observable<Product> {
    console.log(id)
    return this.http.delete<Product>(this.API_URL + '/' + id)
  }
}
