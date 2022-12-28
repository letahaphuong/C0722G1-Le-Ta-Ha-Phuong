import {Component, OnInit} from '@angular/core';
import {Customer} from '../customer';
import {CustomerType} from '../customer-type';

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

  customers: Customer[] = [
    {
      id: 1,
      customerCode: 'KH-1111',
      customerTypeId: this.member,
      name: 'Nguyễn Thị Hào',
      dateOfBirth: '1970-11-07',
      idCard: '643431213',
      phoneNumber: '0945423362',
      gender: false,
      email: 'thihao07@gmail.com',
      address: '23 Nguyễn Hoàng, Đà Nẵng',
      flagDelete: false
    },
    {
      id: 2,
      customerCode: 'KH-1111',
      customerTypeId: this.gold,
      name: 'Phạm Xuân Diệu',
      dateOfBirth: '1992-08-08',
      idCard: '865342123',
      phoneNumber: '0954333333',
      gender: true,
      email: 'xuandieu92@gmail.com',
      address: 'K77/22 Thái Phiên, Quảng Trị',
      flagDelete: false
    },
    {
      id: 3,
      customerCode: 'KH-0001',
      customerTypeId: this.diamond,
      name: 'Trương Định Nghệ',
      dateOfBirth: '1990-02-27',
      idCard: '488645199',
      phoneNumber: '0373213122',
      gender: true,
      email: 'nghenhan2702@gmail.com',
      address: 'K323/12 Ông Ích Khiêm, Vinh',
      flagDelete: false
    },
    {
      id: 4,
      customerCode: 'KH-1111',
      customerTypeId: this.diamond,
      name: 'Dương Văn Quan',
      dateOfBirth: '1981-07-08',
      idCard: '543432111',
      phoneNumber: '0490039241',
      gender: true,
      email: 'duongquan@gmail.com',
      address: 'K453/12 Lê Lợi, Đà Nẵng',
      flagDelete: false
    },
    {
      id: 5,
      customerCode: 'KH-1111',
      customerTypeId: this.silver,
      name: 'Hoàng Trần Nhi Nhi',
      dateOfBirth: '1995-12-09',
      idCard: '795453345',
      phoneNumber: '0312345678',
      gender: false,
      email: 'nhinhi123@gmail.com',
      address: '224 Lý Thái Tổ, Gia Lai',
      flagDelete: false
    },
    {
      id: 6,
      customerCode: 'KH-1111',
      customerTypeId: this.silver,
      name: 'Tôn Nữ Mộc Châu',
      dateOfBirth: '2005-12-06',
      idCard: '732434215',
      phoneNumber: '0988888844',
      gender: false,
      email: 'tonnuchau@gmail.com',
      address: '37 Yên Thế, Đà Nẵng',
      flagDelete: false
    },
    {
      id: 7,
      customerCode: 'KH-1111',
      customerTypeId: this.diamond,
      name: 'Nguyễn Mỹ Kim',
      dateOfBirth: '1984-04-08',
      idCard: '856453123',
      phoneNumber: '0912345698',
      gender: false,
      email: 'kimcuong84@gmail.com',
      address: 'K123/45 Lê Lợi, Hồ Chí Minh',
      flagDelete: false
    },
    {
      id: 8,
      customerCode: 'KH-1111',
      customerTypeId: this.gold,
      name: 'Nguyễn Thị Hào',
      dateOfBirth: '1999-04-08',
      idCard: '965656433',
      phoneNumber: '0763212345',
      gender: false,
      email: 'haohao99@gmail.com',
      address: '55 Nguyễn Văn Linh, Kon Tum',
      flagDelete: false
    },
    {
      id: 9,
      customerCode: 'KH-1111',
      customerTypeId: this.diamond,
      name: 'Trần Đại Danh',
      dateOfBirth: '1994-07-01',
      idCard: '432341235',
      phoneNumber: '0643343433',
      gender: true,
      email: 'danhhai99@gmail.com',
      address: '24 Lý Thường Kiệt, Quảng Ngãi',
      flagDelete: false
    },
    {
      id: 10,
      customerCode: 'KH-1111',
      customerTypeId: this.gold,
      name: 'Nguyễn Tâm Đắc',
      dateOfBirth: '1989-07-01',
      idCard: '344343432',
      phoneNumber: '0987654321',
      gender: true,
      email: 'dactam@gmail.com',
      address: '22 Ngô Quyền, Đà Nẵng',
      flagDelete: false
    },
  ];

  constructor() {
  }

  ngOnInit(): void {
  }

  displayStyle = 'none';
  temp: Customer = {id: 0, name: ''};

  openPopup() {
    this.displayStyle = 'block';
  }

  closePopup() {
    this.displayStyle = 'none';
  }

}
