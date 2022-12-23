import {Component, OnInit} from '@angular/core';
import {Contract} from "../../../../model/contract/contract";

@Component({
  selector: 'app-contract-list',
  templateUrl: './contract-list.component.html',
  styleUrls: ['./contract-list.component.css']
})
export class ContractListComponent implements OnInit {

  contract: Contract = {
    id:1,
    startDate:"2022-12-06",
    endDate:"2022-12-23",
    deposit:1000,
    customer:name,
    employee:name,
    facility:name,
  }

  constructor() {
  }

  ngOnInit(): void {
  }

}
