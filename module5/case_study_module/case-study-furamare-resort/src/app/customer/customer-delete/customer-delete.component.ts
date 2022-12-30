import {Component, Input, OnInit} from '@angular/core';
import {Customer} from '../customer';
import {CustomerService} from '../customer.service';

@Component({
  selector: 'app-customer-delete',
  templateUrl: './customer-delete.component.html',
  styleUrls: ['./customer-delete.component.css']
})
export class CustomerDeleteComponent implements OnInit {
  @Input()
  customer: Customer = {id: 0};

  constructor(private customerService: CustomerService) {
  }

  ngOnInit(): void {
  }

  delete() {
    const id = this.customer.id;
    this.customerService.deleteById(id).subscribe(data => {
      console.log(data);
      document.getElementById('exampleModal')?.click();
      alert('xoá thành công');
      window.location.reload();
    });
  }
}
