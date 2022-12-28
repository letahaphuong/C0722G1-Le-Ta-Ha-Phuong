import {Component, OnInit} from '@angular/core';
import {CustomerType} from '../customer-type';
import {FormControl, FormGroup, Validators} from '@angular/forms';

@Component({
  selector: 'app-customer-edit',
  templateUrl: './customer-edit.component.html',
  styleUrls: ['./customer-edit.component.css']
})
export class CustomerEditComponent implements OnInit {

  customerTypes: CustomerType[] = [
    {
      id: 1,
      name: 'Villa'
    },
    {
      id: 2,
      name: 'House'
    },
    {
      id: 3,
      name: 'Room'
    }
  ];

  contactForm = new FormGroup({
    id: new FormControl(),
    customerCode: new FormControl('', [Validators.required, Validators.pattern('KH-[0-9]{4}')]),
    name: new FormControl('', [Validators.required, Validators.pattern('([A-Z][a-z]+[ ])+([A-Z][a-z]+)')]),
    dateOfBirth: new FormControl(),
    idCard: new FormControl('', [Validators.required, Validators.pattern('[0-9]{9}')]),
    phoneNumber: new FormControl('', [Validators.required, Validators.pattern('(((\\+|)84)|0)(3|5|7|8|9)+([0-9]{8})')]),
    gender: new FormControl(),
    email: new FormControl('', [Validators.required, Validators.pattern('^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$')]),
    address: new FormControl(),
    flagDelete: new FormControl(),
    customerType: new FormGroup({
      id: new FormControl(),
      name: new FormControl()
    })
  });

  get customerCode() {
    return this.contactForm.get('customerCode');
  }

  get name() {
    return this.contactForm.get('name');
  }

  get idCard() {
    return this.contactForm.get('idCard');
  }

  get phoneNumber() {
    return this.contactForm.get('phoneNumber');
  }

  get email() {
    return this.contactForm.get('email');
  }

  constructor() {
  }

  ngOnInit(): void {
  }

  onSubmit() {
    console.log(this.contactForm.value);
  }

}
