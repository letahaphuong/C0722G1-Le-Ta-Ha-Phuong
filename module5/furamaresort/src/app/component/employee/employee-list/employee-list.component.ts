import { Component, OnInit } from '@angular/core';
import {Employee} from "../../../../model/employee/employee";

@Component({
  selector: 'app-employee-list',
  templateUrl: './employee-list.component.html',
  styleUrls: ['./employee-list.component.css']
})
export class EmployeeListComponent implements OnInit {

  employee:Employee ={
    id:1,
    name:"Nguyễn Văn A",
    dateOfBirth:"1995-06-06",
    idCard:"205877721",
    salary:2000,
    phoneNumber:"0964808185",
    email:"letahaphuong@gmail.com",
    address:"Hội An",
    position:name,
    division:name,
    educationDegree:name,
  }

  constructor() { }

  ngOnInit(): void {
  }

}
