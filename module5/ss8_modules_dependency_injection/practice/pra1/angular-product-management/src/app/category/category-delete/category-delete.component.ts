import {Component, Input, OnInit} from '@angular/core';
import {Category} from "../../model/category";
import {FormGroup} from "@angular/forms";
import {CategoryService} from "../../service/category.service";

@Component({
  selector: 'app-category-delete',
  templateUrl: './category-delete.component.html',
  styleUrls: ['./category-delete.component.css']
})
export class CategoryDeleteComponent implements OnInit {
  @Input() category: Category = {};
  deleteForm: FormGroup=new FormGroup({});

  constructor(private categoryService:CategoryService) {
  }

  ngOnInit(): void {
  }

  delete() {
    this.categoryService.delete(this.category.id);
    document.getElementById('exampleModal')?.click();
  }
}
