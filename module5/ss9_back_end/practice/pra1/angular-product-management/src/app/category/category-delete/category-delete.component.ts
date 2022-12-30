import {Component, Input, OnInit} from '@angular/core';
import {Category} from "../../model/category";
import {FormControl, FormGroup} from "@angular/forms";
import {CategoryService} from "../../service/category.service";
import {ActivatedRoute, ParamMap, Router} from "@angular/router";

@Component({
  selector: 'app-category-delete',
  templateUrl: './category-delete.component.html',
  styleUrls: ['./category-delete.component.css']
})
export class CategoryDeleteComponent implements OnInit {
  @Input() category: Category = {};
  deleteForm: FormGroup = new FormGroup({});
  private id: number | undefined;
  categoryForm: FormGroup=new FormGroup({});

  constructor(private categoryService: CategoryService,
              private router: Router,
              private activatedRoute: ActivatedRoute) {
    this.activatedRoute.paramMap.subscribe((paramMap: ParamMap) => {
      // @ts-ignore
      this.id = +paramMap.get('id');
      this.getCategory(this.id);
    });
  }

  getCategory(id: number) {
    return this.categoryService.findById(id).subscribe(category => {
      this.deleteForm = new FormGroup({
        name: new FormControl(category.name),
      });
    });
  }

  ngOnInit(): void {
  }

  delete(id: number) {
    this.categoryService.delete(id).subscribe(()=>{
      this.router.navigate(['/category/list'])
    },error => {
      console.log(error)
    })
  }
}
