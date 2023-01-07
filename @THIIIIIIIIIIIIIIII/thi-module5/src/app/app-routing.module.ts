import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {ComponentListComponent} from "./component/component-list/component-list.component";
import {ComponentCreateComponent} from "./component/component-create/component-create.component";
import {ComponentEditComponent} from "./component/component-edit/component-edit.component";
import {ComponentDeleteComponent} from "./component/component-delete/component-delete.component";

const routes: Routes = [
  {
    path: '',component: ComponentListComponent
  },
  {
    path: 'create',component: ComponentCreateComponent
  },
  {
    path: 'edit/:id',component: ComponentEditComponent
  },
  {
    path: 'delete/:id',component: ComponentDeleteComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
