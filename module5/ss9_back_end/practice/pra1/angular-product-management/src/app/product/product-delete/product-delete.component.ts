import {Component, Input, OnInit,SimpleChanges} from '@angular/core';
import {Product} from "../../model/product";
import {ProductService} from "../../service/product.service";
import {ok} from "assert";
import {FormGroup} from "@angular/forms";
import {emit} from "cluster";

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
    const id = this.product.id;
    console.log('id nè'+id)
    this.productService.deleteById(id).subscribe(data =>{
      console.log(data)
      document.getElementById('exampleModal')?.click();
      alert('xoá thành công');
      window.location.reload();
    },error => {
      console.log(error)
    },()=>{

    })
  }
}
