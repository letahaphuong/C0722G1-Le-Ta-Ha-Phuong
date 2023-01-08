import {Component, OnInit} from '@angular/core';
import {LoHangService} from "../service/lo-hang.service";
import {SanPham} from "../model/san-pham";
import {LoHangDto} from "../model/lo-hang-dto";

@Component({
  selector: 'app-component-list',
  templateUrl: './component-list.component.html',
  styleUrls: ['./component-list.component.css']
})
export class ComponentListComponent implements OnInit {
  loHangs: LoHangDto[] = [];
  p = 1;

  sanPhams: SanPham[] = [];

  temp: LoHangDto = {id: 0}

  tenSanPham = '';
  page: number = 0;
  totalPage: number = 0;
  size: number = 0;

  constructor(private loHangService: LoHangService) {
  }

  ngOnInit(): void {
    this.getAllLoHang(this.page);
    this.getAllLSanPham();
  }

  getAllLoHang(page: number) {
    this.loHangService.getAll(page).subscribe(data => {
        console.log(data)
        this.loHangs = data['content'];
        this.page = data['number'];
        this.totalPage= data['totalPages'];
        this.size = data['size'];
      console.log('content' + this.loHangs);
      console.log('page' + this.page);
      console.log('totalPage' + this.totalPage);
      console.log('size' + this.size);
      }
    );
    this.getAllLSanPham();
  }

  getAllLSanPham() {
    this.loHangService.getAllSanPham().subscribe(data => {
      console.log(data)
      this.sanPhams = data;
    })
  }

  reload() {
    this.getAllLoHang(this.page);
    this.getAllLSanPham();
  }

  previousPage() {
    if (this.page > 0) {
      this.page = this.page - 1;
      this.getAllLoHang(this.page);
    }
  }

  nextPage() {
    if (this.page < this.totalPage - 1) {
      this.page = this.page + 1;
      this.getAllLoHang(this.page);
    }

  }
  ngay1 ='';
  ngay2='';
  ngayHetHan='';
  search(ngay1: string, ngay2: string, tenSanPham: string, ngayHetHan: string) {
    this.loHangService.search(ngay1,ngay2,tenSanPham,ngayHetHan,this.page).subscribe(data =>{
      this.loHangs = data['content'];
    })
  }
}
