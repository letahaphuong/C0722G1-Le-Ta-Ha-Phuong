import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {SanPhamService} from "../service/san-pham.service";
import {FormControl, FormGroup} from "@angular/forms";
import {ToastrService} from "ngx-toastr";

@Component({
  selector: 'app-component-create-san-pham',
  templateUrl: './component-create-san-pham.component.html',
  styleUrls: ['./component-create-san-pham.component.css']
})
export class ComponentCreateSanPhamComponent implements OnInit {
  createFromSp: FormGroup;
  @Output()
  eventCreateSp = new EventEmitter();

  constructor(private sanPhamService: SanPhamService, private toast: ToastrService) {
    this.createFromSp = new FormGroup({
      id: new FormControl(),
      tenSanPham: new FormControl(),
      xuatXu: new FormControl(),
      giaTien: new FormControl(),
      donVi: new FormControl(),
    })
  }

  ngOnInit(): void {
    this.sanPhamService.getAllSanPham().subscribe(data => {
      console.log(data);
    })
  }

  createSp() {
    const sanPham = this.createFromSp.value;
    this.sanPhamService.saveSanPham(sanPham).subscribe(data => {
      this.createFromSp.reset();
      this.eventCreateSp.emit();
      this.toast.success('Thêm mới thành công', 'Thông báo')
    }, error => {
      this.toast.error('Thêm mới không thành công', 'Thông báo')
    })
  }

}
