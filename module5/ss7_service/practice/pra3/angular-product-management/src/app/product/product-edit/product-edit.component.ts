import {Component, OnInit} from '@angular/core';
import {ProductService} from "../../service/product.service";
import {ActivatedRoute} from "@angular/router";
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


  constructor(private productService: ProductService,
              private activatedRoute: ActivatedRoute) {
    this.activatedRoute.paramMap.subscribe(data => {
      const id = data.get('id');
      if (id != null) {
        this.product = this.productService.findById(parseInt(id));
        console.log(this.product)
      }
    }, error => {

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

  ngOnInit(): void {
  }

  edit() {
    const productEdit= this.productFormReact.value;
    const id= this.productFormReact.value.id
    this.productService.editProduct(id,productEdit);
    console.log(name)
  }


}
