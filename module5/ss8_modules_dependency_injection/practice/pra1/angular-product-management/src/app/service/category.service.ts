import {Injectable} from '@angular/core';
import {Category} from "../model/category";
import {element} from "protractor";
import {Router} from "@angular/router";
import {environment} from "../../environments/environment";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

const API_URL=`${environment.apiUrl}`
@Injectable({
  providedIn: 'root'
})
export class CategoryService {
  categories: Category[] = [
    {
    id: 1,
    name: 'IPhone'
  }, {
    id: 2,
    name: 'Samsung',
  }, {
    id: 3,
    name: 'LG',
  }
  ];

  constructor(private router: Router,
              private http: HttpClient
              ) {
  }

  // getAll(): Observable<Category[]>{
  //   return this.http.get<Category[]>(API_URL + '/categories');
  // }
  getAll() {
    return this.categories;
  }

  // findById(id: number): Observable<Category>{
  //   return this.http.get<Category>(`${API_URL}/categories/${id}`);
  // }
  //
  // saveCategory({category}: { category: any }):Observable<Category>{
  //   return this.http.post<Category>(API_URL+'/',category)
  // }
  //
  // editCategory(id:number,category:Category): Observable<Category>{
  //   return this.http.patch<Category>(`${API_URL}/categories/${id}`,category)
  // }
  findById(id: number) {
    let temp = this.categories.filter(element => element.id === id);
    if (temp.length === 0) {
      return null;
    }
    return temp[0];
  }

  saveCategory(category: Category) {
    this.categories.push(category)
  }

  editCategory(id: number, category1: Category) {

    for (let i = 0; i < this.categories.length; i++) {
      console.log(this.categories[i])
      if (this.categories[i].id === id) {
        this.categories[i] = category1;
      }
    }
    this.router.navigateByUrl('category/list')
  }

  delete(id: number | undefined) {
    if (id != undefined) {
      let category = this.findById(id);
      if (category != null) {
        let length = this.categories.length
        for (let i = 0; i < length; i++) {
          if (this.categories[i].id == category.id) {
            this.categories.splice(i, 1);
            break;
          }
        }
      }
    }
  }
}
