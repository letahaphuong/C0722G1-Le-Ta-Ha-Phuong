import {Component, OnInit} from '@angular/core';
import {Todo} from '../todo';
import {FormControl, FormGroup, Validator} from '@angular/forms';
import {HttpClient, HttpClientModule} from "@angular/common/http";
import {TodoService} from "../service/todo.service";

let _id = 1;

@Component({
  selector: 'app-todo',
  templateUrl: './todo.component.html',
  styleUrls: ['./todo.component.css']
})
export class TodoComponent implements OnInit {
  todos: Todo[] = [];
  content = new FormControl();

  constructor(private todoService: TodoService) {
    this.todoService.getAll().subscribe(data => {
      console.log(data);
      this.todos = data;
    }, error => {

    }, () => {

    })
  }

  ngOnInit(): void {
  }

  toggleTodo(i: number) {
    this.todos[i].complete = !this.todos[i].complete;
  }

  change() {
    const value = this.content.value;
    if (value) {
      const todo: Todo = {
        content: value,
        complete: false
      };
      this.todoService.saveTodo(todo).subscribe(data => {
        console.log('data thêm nè'+data)
      },error => {

      },()=>{

      });
      this.todoService.getAll().subscribe(data => {
        this.todos = data;
        console.log(this.todos);
        this.content.reset();
      },error => {

      },()=>{

      });

    }
  }
  deleteTodo(number: any){
    this.todoService.deleteId(parseInt(number)).subscribe(data => {
      console.log('data xoá nè'+data)
    });
    alert("Bạn có muốn xoá")
    this.todoService.getAll().subscribe(data => {
      this.todos = data;
    })
  }
}
