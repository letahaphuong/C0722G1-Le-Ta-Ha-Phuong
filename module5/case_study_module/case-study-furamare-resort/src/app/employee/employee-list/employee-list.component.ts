import {Component, OnInit} from '@angular/core';
import {Division} from '../division';
import {EducationDegree} from '../education-degree';
import {Employee} from '../employee';

@Component({
  selector: 'app-employee-list',
  templateUrl: './employee-list.component.html',
  styleUrls: ['./employee-list.component.css']
})
export class EmployeeListComponent implements OnInit {
  saleMarketing: Division = {
    id: 1,
    name: 'Sale-Marketing'
  };
  hanhChinh: Division = {
    id: 2,
    name: 'Hành Chính'
  };
  phucVu: Division = {
    id: 3,
    name: 'Phục vụ'
  };
  quanLy: Division = {
    id: 4,
    name: 'Quản lý'
  };

  trungCap: EducationDegree = {
    id: 1,
    name: 'Trung cấp'
  };
  caoDang: EducationDegree = {
    id: 2,
    name: 'Cao Đẳng'
  };
  daiHoc: EducationDegree = {
    id: 3,
    name: 'Đại học'
  };
  sauDaiHoc: EducationDegree = {
    id: 4,
    name: 'Sau Đại học'
  };
  employe: Employee[] = [
    {
      id: 1,
      name: 'Nguyễn Văn An',
      dateOfBirth: '1970-11-07',
      idCard: '456231786',
      salary: 10000000,
      phoneNumber: '0901234121',
      email: 'annguyen@gmail.com',
      address: '295 Nguyễn Tất Thành, Đà Nẵng',
      position: {
        id: 1,
        name: 'Quản Lý'
      },
      division: this.phucVu,
      educationDegree: this.daiHoc,
      flagDelete: false
    },
    {
      id: 2,
      name: 'Lê Văn Bình',
      dateOfBirth: '1997-04-09',
      idCard: '654231234',
      salary: 7000000,
      phoneNumber: '654231234',
      email: 'binhlv@gmail.com',
      address: '22 Yên Bái, Đà Nẵng',
      position: {
        id: 1,
        name: 'Quản Lý'
      },
      division: this.hanhChinh,
      educationDegree: this.caoDang,
      flagDelete: false
    },
    {
      id: 3,
      name: 'Hồ Thị Yến',
      dateOfBirth: '1995-12-12',
      idCard: '999231723',
      salary: 14000000,
      phoneNumber: '0412352315',
      email: 'thiyen@gmail.com',
      address: 'K234/11 Điện Biên Phủ, Gia Lai',
      position: {
        id: 1,
        name: 'Quản Lý'
      },
      division: this.hanhChinh,
      educationDegree: this.daiHoc,
      flagDelete: false
    },
    {
      id: 4,
      name: 'Võ Công Toản',
      dateOfBirth: '1980-04-04',
      idCard: '123231365',
      salary: 17000000,
      phoneNumber: '0374443232',
      email: 'toan0404@gmail.com',
      address: '77 Hoàng Diệu, Quảng Trị',
      position: {
        id: 1,
        name: 'Quản Lý'
      },
      division: this.quanLy,
      educationDegree: this.sauDaiHoc,
      flagDelete: false
    },
    {
      id: 5,
      name: 'Nguyễn Bỉnh Phát',
      dateOfBirth: '1999-12-09',
      idCard: '454363232',
      salary: 6000000,
      phoneNumber: '0902341231',
      email: 'phatphat@gmail.com',
      address: '43 Yên Bái, Đà Nẵng',
      position: {
        id: 2,
        name: 'Nhân viên'
      },
      division: this.saleMarketing,
      educationDegree: this.trungCap,
      flagDelete: false
    },
    {
      id: 6,
      name: 'Khúc Nguyễn An Nghi',
      dateOfBirth: '2000-11-08',
      idCard: '964542311',
      salary: 7000000,
      phoneNumber: '0978653213',
      email: 'annghi20@gmail.com',
      address: '294 Nguyễn Tất Thành, Đà Nẵng',
      position: {
        id: 2,
        name: 'Nhân viên'
      },
      division: this.hanhChinh,
      educationDegree: this.caoDang,
      flagDelete: false
    },
    {
      id: 7,
      name: 'Nguyễn Hữu Hà',
      dateOfBirth: '1993-01-01',
      idCard: '534323231',
      salary: 8000000,
      phoneNumber: '0941234553',
      email: 'nhh0101@gmail.com',
      address: '4 Nguyễn Chí Thanh, Huế',
      position: {
        id: 2,
        name: 'Nhân viên'
      },
      division: this.hanhChinh,
      educationDegree: this.daiHoc,
      flagDelete: false
    },
    {
      id: 8,
      name: 'Nguyễn Hà Đông',
      dateOfBirth: '1989-09-03',
      idCard: '234414123',
      salary: 9000000,
      phoneNumber: '0642123111',
      email: 'donghanguyen@gmail.com',
      address: '111 Hùng Vương, Hà Nội',
      position: {
        id: 2,
        name: 'Nhân viên'
      },
      division: this.quanLy,
      educationDegree: this.sauDaiHoc,
      flagDelete: false
    },
    {
      id: 9,
      name: 'Tòng Hoang',
      dateOfBirth: '1982-09-03',
      idCard: '256781231',
      salary: 6000000,
      phoneNumber: '0245144444',
      email: 'hoangtong@gmail.com',
      address: '213 Hàm Nghi, Đà Nẵng',
      position: {
        id: 2,
        name: 'Nhân viên'
      },
      division: this.quanLy,
      educationDegree: this.sauDaiHoc,
      flagDelete: false
    },
    {
      id: 10,
      name: 'Nguyễn Công Đạo',
      dateOfBirth: '1994-01-08',
      idCard: '755434343',
      salary: 8000000,
      phoneNumber: '0988767111',
      email: 'nguyencongdao12@gmail.com',
      address: '6 Hoà Khánh, Đồng Nai',
      position: {
        id: 2,
        name: 'Nhân viên'
      },
      division: this.hanhChinh,
      educationDegree: this.daiHoc,
      flagDelete: false
    },
  ];

  constructor() {
  }

  ngOnInit(): void {
  }

}
