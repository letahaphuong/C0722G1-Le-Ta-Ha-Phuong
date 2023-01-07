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
  page = 0;
  totalElements: number = 0;

  constructor(private loHangService: LoHangService) {
  }

  ngOnInit(): void {
    this.getAllLoHang();
    this.getAllLSanPham();
  }

  getAllLoHang() {
    this.loHangService.getAll().subscribe(data => {
        console.log(data)
        this.loHangs = data.content;
      }
    );
    this.getAllLSanPham();
  }
  getAllLSanPham(){
    this.loHangService.getAllSanPham().subscribe(data => {
      console.log(data)
      this.sanPhams = data;
    })
  }

  reload() {
    this.getAllLoHang();
    this.getAllLSanPham();
  }

}
