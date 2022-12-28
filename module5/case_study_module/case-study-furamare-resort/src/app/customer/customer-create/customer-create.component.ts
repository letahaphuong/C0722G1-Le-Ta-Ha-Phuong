import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {CustomerType} from '../customer-type';

@Component({
  selector: 'app-customer-create',
  templateUrl: './customer-create.component.html',
  styleUrls: ['./customer-create.component.css']
})
export class CustomerCreateComponent implements OnInit {

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

  constructor() {
  }

  ngOnInit(): void {
  }

  contactForm = new FormGroup({
    id: new FormControl(),
    customerCode: new FormControl('', [Validators.required, Validators.pattern('KH-[0-9]{4}')]),
    name: new FormControl('', [Validators.required, Validators.pattern('([A-Z][a-z]+[ ])+([A-Z][a-z]+)')]),
    dateOfBirth: new FormControl(),
    idCard: new FormControl('', [Validators.required, Validators.pattern('([0-9]{9})$|^([0-9]{12})')]),
    phoneNumber: new FormControl('', [Validators.required, Validators.pattern('(((\\+|)84)|0)(3|5|7|8|9)+([0-9]{8})')]),
    gender: new FormControl(),
    email: new FormControl('', [Validators.required, Validators.email]),
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

  onSubmit() {
    console.log(this.contactForm.value);
  }

}
