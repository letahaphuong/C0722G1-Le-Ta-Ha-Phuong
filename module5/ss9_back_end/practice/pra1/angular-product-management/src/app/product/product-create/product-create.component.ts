import {Component, OnInit} from '@angular/core';
import {Product} from "../../model/product";
import {FormControl, FormGroup} from "@angular/forms";
import {ProductService} from "../../service/product.service";
import {Category} from "../../model/category";
import {CategoryService} from "../../service/category.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-product-create',
  templateUrl: './product-create.component.html',
  styleUrls: ['./product-create.component.css']
})
export class ProductCreateComponent implements OnInit {

  productForm: FormGroup;

  categorys: Category[] = [];


  constructor(private productService: ProductService,
              private categoryService: CategoryService,
              private router: Router
  ) {
    this.productForm = new FormGroup({
      id: new FormControl(),
      name: new FormControl(),
      price: new FormControl(),
      description: new FormControl(),
      category: new FormControl()
    })
    this.categoryService.getAll().subscribe(data => {
      this.categorys = data;
    }, error => {

    }, () => {

    });
  }

  create() {
    this.productForm.value.id = parseInt(this.productForm.value.id)
    const product = this.productForm.value;
    this.productService.saveProduct(product).subscribe(data => {
      this.productForm.reset();
      alert('thêm mới thành công')
    }, error => {
      console.log(error)
    }, () => {
    this.router.navigateByUrl("/product/list")
    })
  }


  ngOnInit(): void {
  }

}
