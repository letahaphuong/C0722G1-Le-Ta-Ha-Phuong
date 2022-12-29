import {Component, OnInit} from '@angular/core';
import {Category} from "../../model/category";
import {FormControl, FormGroup} from "@angular/forms";
import {CategoryService} from "../../service/category.service";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-category-edit',
  templateUrl: './category-edit.component.html',
  styleUrls: ['./category-edit.component.css']
})
export class CategoryEditComponent implements OnInit {
  category: Category |null = {};

  categoryForm: FormGroup;
  private id: number | undefined;


  constructor(private categoryService: CategoryService,
              private activatedRoute: ActivatedRoute,
              private router: Router
  ) {

    // this.activatedRoute.paramMap.subscribe((paramMap) => {
    //   // @ts-ignore
    //   this.id = +paramMap.get('id');
    //   this.getCategory(this.id);
    // }, error => {
    //
    // }, () => {
    //
    // })

    this.activatedRoute.paramMap.subscribe(data =>{
      const id = data.get('id');
      if (id!=null){
        this.category = this.categoryService.findById(parseInt(id));
      }
    },error => {
      console.log(error)
    },()=>{

    })
    this.categoryForm = new FormGroup(
      {
        id: new FormControl(this.category?.id),
        name: new FormControl(this.category?.name)
      }
    )
  }

  // getCategory(id: number) {
  //   return this.categoryService.findById(id).subscribe(category => {
  //     this.categoryForm = new FormGroup({
  //       name: new FormControl(category.name),
  //     });
  //   });
  // }

  ngOnInit(): void {
  }

  // edit() {
  //   const categoryEdit = this.categoryForm.value;
  //   const id = this.categoryForm.value.id;
  //   this.categoryService.editCategory(id, categoryEdit).subscribe(() =>{
  //     alert('cập nhật thành công');
  //   },error => {
  //     console.log(error)
  //   })
  //   // console.log(categoryEdit.id)
  // }

  edit(){
    const categoryEdit = this.categoryForm.value;
    const id = this.categoryForm.value.id;
    this.categoryService.editCategory(id,categoryEdit);
    console.log(id)
  }

}
