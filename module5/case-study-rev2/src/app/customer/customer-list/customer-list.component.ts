import {Component, OnInit} from '@angular/core';
import {Customer} from '../model/customer';
import {CustomerService} from '../service/customer.service';

@Component({
  selector: 'app-customer-list',
  templateUrl: './customer-list.component.html',
  styleUrls: ['./customer-list.component.css']
})
export class CustomerListComponent implements OnInit {
  customers: Customer[] = [];
  temp: Customer = {id: 0};
  p = 1;
  searchText: any;
  constructor(private customerService: CustomerService) {
  }

  ngOnInit(): void {
    this.getAll();
  }

  reload(): void {
    this.getAll();
  }

  getAll(): void {
    this.customerService.getAll().subscribe(data => {
      this.customers = data;
    });
  }
}
