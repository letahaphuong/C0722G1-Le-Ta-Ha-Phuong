import {Component, OnInit} from '@angular/core';
import {Customer} from '../customer';
import {CustomerType} from '../customer-type';
import {CustomerService} from '../customer.service';
import {Observable} from 'rxjs';

@Component({
  selector: 'app-customer-list',
  templateUrl: './customer-list.component.html',
  styleUrls: ['./customer-list.component.css']
})
export class CustomerListComponent implements OnInit {

  diamond: CustomerType = {
    id: 1,
    name: 'Diamond'
  };
  platinium: CustomerType = {
    id: 2,
    name: 'Platinium'
  };
  gold: CustomerType = {
    id: 3,
    name: 'Gold'
  };
  silver: CustomerType = {
    id: 4,
    name: 'Silver'
  };
  member: CustomerType = {
    id: 5,
    name: 'Member'
  };

  customers: Customer[] = [];
  temp: Customer = {id: 0};

  constructor(private customerService: CustomerService) {
  }

  ngOnInit(): void {
    this.customerService.getAll().subscribe(data => {
      this.customers = data;
    });
  }
}
