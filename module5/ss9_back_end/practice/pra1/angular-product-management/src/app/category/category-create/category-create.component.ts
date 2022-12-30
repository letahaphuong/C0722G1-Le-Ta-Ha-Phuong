import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup} from "@angular/forms";
import {CategoryService} from "../../service/category.service";

@Component({
  selector: 'app-category-create',
  templateUrl: './category-create.component.html',
  styleUrls: ['./category-create.component.css']
})
export class CategoryCreateComponent implements OnInit {
  categoryForm: FormGroup;

  constructor(private categoryService: CategoryService,) {
    this.categoryForm = new FormGroup(
      {
        id: new FormControl(),
        name: new FormControl()
  }
  )
  }

  ngOnInit(): void {
  }


  create() {
    this.categoryForm.value.id = parseInt(this.categoryForm.value.id);
    const category = this.categoryForm.value;
    this.categoryService.saveCategory(category).subscribe(data => {
      this.categoryForm.reset();
      alert('thêm mới thành công');
      // console.log(category)
    }, error => {
      console.log(error)
    })

  }

}
