import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {TodoEidtComponent} from "./todo-eidt/todo-eidt.component";

const routes: Routes = [
  {
    path:"todo/edit/:id",
    component: TodoEidtComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
