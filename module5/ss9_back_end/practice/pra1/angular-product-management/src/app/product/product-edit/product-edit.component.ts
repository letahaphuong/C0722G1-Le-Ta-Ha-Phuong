import {Component, OnInit} from '@angular/core';
import {ProductService} from "../../service/product.service";
import {ActivatedRoute, Router} from "@angular/router";
import {Product} from "../../model/product";
import {FormControl, FormGroup} from "@angular/forms";

@Component({
  selector: 'app-product-edit',
  templateUrl: './product-edit.component.html',
  styleUrls: ['./product-edit.component.css']
})
export class ProductEditComponent implements OnInit {

  product: Product | null = {};

  productFormReact: FormGroup;
  private id: number | undefined;


  constructor(private productService: ProductService,
              private activatedRoute: ActivatedRoute,
              private router: Router
              ) {
    this.activatedRoute.paramMap.subscribe(paramMap => {
      // @ts-ignore
      this.id = +paramMap.get('id');
      this.getProduct(this.id);
    }, error => {
      console.log(error)
    }, () => {

    })
    this.productFormReact = new FormGroup(
      {
        id: new FormControl(this.product?.id),
        name: new FormControl(this.product?.name),
        price: new FormControl(this.product?.price),
        description: new FormControl(this.product?.description)
      }
    )

  }

  getProduct(id: number) {
    return this.productService.findById(id).subscribe(product => {
      this.productFormReact = new FormGroup({
        id: new FormControl(product.id),
        name: new FormControl(product.name),
        price: new FormControl(product.price),
        description: new FormControl(product.description),
        category: new FormControl(product.category)
      })
    })
  }

  ngOnInit(): void {
  }

  edit() {
    const productEdit = this.productFormReact.value;
    const id = +this.productFormReact.value.id
    this.productService.editProduct(id, productEdit).subscribe(data =>{
      alert('thêm mới thành công')
    },error => {
      console.log(error);
    },()=>{
      this.router.navigateByUrl("product/list")
    });
  }


}
