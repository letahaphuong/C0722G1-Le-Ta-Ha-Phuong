import {Component, OnInit} from '@angular/core';
import {Contract} from "../../../../model/contract/contract";
import {Customer} from "../../../../model/customer/customer";
import {Facility} from "../../../../model/facility/facility";
import {Employee} from "../../../../model/employee/employee";

@Component({
  selector: 'app-contract-list',
  templateUrl: './contract-list.component.html',
  styleUrls: ['./contract-list.component.css']
})
export class ContractListComponent implements OnInit {
  1: Customer = {
    id: 1,
    name: "Nguyễn Thị Hào",
  }

  2: Customer = {
    id: 2,
    name: "Phạm Xuân Diệu",
  }
  3: Customer = {
    id: 3
    ,
    name: "Trương Định Nghệ"
  }


  4: Customer = {
    id: 4,
    name: "Dương Văn Quan"
  }
  5: Customer = {
    id: 5,
    name: "Hoàng Trần Nhi Nhi"
  }
  6: Customer = {
    id: 6,
    name: "Tôn Nữ Mộc Châu",
  }
  7: Customer = {
    id: 7,
    name: "Nguyễn Mỹ Kim"
  }
  8: Customer = {
    id: 8,
    name: "Nguyễn Thị Hào"
  }
  9: Customer = {
    id: 9,
    name: "Trần Đại Danh"
  }
  10: Customer = {
    id: 10,
    name: "Nguyễn Tâm Đắc",
  }

  villaBeachFront: Facility = {
    id: 1,
    name: "Villa Beach Front",
  }
  housePrincess01: Facility = {
    id: 2,
    name: "House Princess 01",
  }
  roomTwin01: Facility = {
    id: 3,
    name: "Room Twin 01",
  }
  villaNoBeachFront: Facility = {
    id: 4,
    name: "Villa No Beach Front",
  }
  housePrincess02: Facility = {
    id: 5,
    name: "House Princess 02",
  }
  roomTwin02: Facility = {
    id: 6,
    name: "Room Twin 02",
  }

    nguyenvanAn:Employee={
      id: 1,
      name: "Nguyễn Văn An",
    }
    leVanBinh:Employee={
      id: 2,
      name: "Lê Văn Bình",
    }
    hoThiYen:Facility={
      id: 3,
      name: "Hồ Thị Yến",
    }
    voCongToan:Employee={
      id: 4,
      name: "Võ Công Toản",
    }
    nguyenBinhPhat:Employee={
      id: 5,
      name: "Nguyễn Bỉnh Phát",
    }
    khucNguyenAnNghi:Employee={
      id: 6,
      name: "Khúc Nguyễn An Nghi",
    }
    nguyenHuuHa:Employee={
      id: 7,
      name: "Nguyễn Hữu Hà",
    }
    nguyenHaDong:Employee={
      id: 8,
      name: "Nguyễn Hà Đông",
    }
    tongHoan:Employee={
      id: 9,
      name: "Tòng Hoang",
    }
    nguyenCongdao:Employee={
      id: 10,
      name: "Nguyễn Công Đạo",
    }

contracts: Contract[] = [
  {
    id:1,
    startDate:"2020-12-08",
    endDate:"2020-12-08",
    deposit:0,
    customer:this["1"],
    employee:this.hoThiYen,
    facility:this.roomTwin01
  },
  {
    id:2,
    startDate:"2020-07-14",
    endDate:"2020-07-21",
    deposit:200000,
    customer:this["3"],
    employee:this.nguyenHuuHa,
    facility:this.villaBeachFront
  },
  {
    id:3,
    startDate:"2021-03-15",
    endDate:"2021-03-17",
    deposit:50000,
    customer:this["4"],
    employee:this.hoThiYen,
    facility:this.housePrincess01
  },
  {
    id:4,
    startDate:"2021-01-14",
    endDate:"2021-01-18",
    deposit:100000,
    customer:this["5"],
    employee:this.nguyenHuuHa,
    facility:this.housePrincess02
  },
  {
    id:5,
    startDate:"2021-07-14",
    endDate:"2021-07-15",
    deposit:0,
    customer:this["2"],
    employee:this.nguyenHuuHa,
    facility:this.roomTwin02
  },
  {
    id:6,
    startDate:"2021-06-01",
    endDate:"2021-06-03",
    deposit:0,
    customer:this["7"],
    employee:this.nguyenHuuHa,
    facility:this.roomTwin02
  },
  {
    id:7,
    startDate:"2021-09-02",
    endDate:"2021-09-05",
    deposit:100000,
    customer:this["4"],
    employee:this.nguyenHuuHa,
    facility:this.voCongToan
  },
  {
    id:8,
    startDate:"2021-06-17",
    endDate:"2021-06-18",
    deposit:150000,
    customer:this["4"],
    employee:this.hoThiYen,
    facility:this.villaBeachFront
  },
  {
    id:9,
    startDate:"2020-11-19",
    endDate:"2020-11-19",
    deposit:0,
    customer:this["4"],
    employee:this.hoThiYen,
    facility:this.roomTwin01
  },
  {
    id:10,
    startDate:"2021-04-12",
    endDate:"2021-04-14",
    deposit:0,
    customer:this["3"],
    employee:this.nguyenCongdao,
    facility:this.housePrincess02
  },
  {
    id:11,
    startDate:"2021-04-25",
    endDate:"2021-04-25",
    deposit:0,
    customer:this["2"],
    employee:this.leVanBinh,
    facility:this.villaBeachFront
  },
  {
    id:12,
    startDate:"2021-05-25",
    endDate:"2021-05-27",
    deposit:0,
    customer:this["10"],
    employee:this.nguyenHuuHa,
    facility:this.villaBeachFront
  },
]

  constructor() {
  }

  ngOnInit()
    :
    void {
  }

}
