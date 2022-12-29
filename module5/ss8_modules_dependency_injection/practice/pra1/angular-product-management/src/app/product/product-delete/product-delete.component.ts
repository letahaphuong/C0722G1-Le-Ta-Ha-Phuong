import {Component, Input, OnInit,SimpleChanges} from '@angular/core';
import {Product} from "../../model/product";
import {ProductService} from "../../service/product.service";
import {ok} from "assert";
import {FormGroup} from "@angular/forms";

@Component({
  selector: 'app-product-delete',
  templateUrl: './product-delete.component.html',
  styleUrls: ['./product-delete.component.css']
})
export class ProductDeleteComponent implements OnInit {
  @Input()
  product: Product={};
  deleteForm: FormGroup = new FormGroup({});

  constructor(private productService: ProductService) { }

  ngOnInit(): void {
  }

  delete() {
    this.productService.deleteById(this.product.id);
    document.getElementById('exampleModal')?.click();
  }
}
