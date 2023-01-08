import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {SanPham} from "../model/san-pham";
import {LoHangService} from "../service/lo-hang.service";
import {ToastrService} from "ngx-toastr";
import {Router} from "@angular/router";
import {AbstractControl, FormControl, FormGroup, Validators} from "@angular/forms";
import {differenceInDays} from 'date-fns';

@Component({
  selector: 'app-component-create',
  templateUrl: './component-create.component.html',
  styleUrls: ['./component-create.component.css']
})
export class ComponentCreateComponent implements OnInit {
  sanPhans: SanPham [] = [];
  createForm: FormGroup;

  @Output()
  eventCreate = new EventEmitter();

  constructor(private loHangService: LoHangService, private toast: ToastrService, private router: Router) {
    this.loHangService.getAllSanPham().subscribe(data => {
      console.log(data);
      this.sanPhans = data;
    });

    this.createForm = new FormGroup({
      id: new FormControl(),
      maLoHang: new FormControl('', [Validators.required, Validators.pattern('LH-[0-9]{4}')]),
      sanPham: new FormControl('', [Validators.required]),
      soLuong: new FormControl('', [Validators.required, Validators.min(0)]),
      ngayNhap: new FormControl('', [Validators.required]),
      ngaySanXuat: new FormControl('', [Validators.required]),
      ngayHetHan: new FormControl('', [Validators.required,this.validateDate]),
    },{
      validators:this.validateDate
    })
  }

  ngOnInit(): void {
  }

  validateDate(c: AbstractControl) {
    let ngaySanXuat = new Date(c.get('ngaySanXuat')?.value);
    console.log(ngaySanXuat)
    let ngayHetHan = new Date(c.get('ngayHetHan')?.value);
    console.log(ngayHetHan)
    let check = differenceInDays(ngayHetHan, ngaySanXuat);
    console.log('mã : ' + check)
    return (check < 0) ? {'endDateAfterStartDate': true} : null;

  }

  createLoHag() {
    const loHang = this.createForm.value;
    this.loHangService.saveLoHang(loHang).subscribe(data => {
      this.createForm.reset();
      this.eventCreate.emit();
      this.toast.success('Thêm mới thành công', 'Thông Báo')
    }, error => {
      this.toast.error('Thêm mới không thành công. Vui lòng thử lại', 'Thông Báo')
    })
  }

  getAllSanPham() {
    this.loHangService.getAllSanPham().subscribe(data => {
      console.log(data);
    })
  }

  // getAllLoHang() {
  //   this.loHangService.getAll().subscribe(data => {
  //     console.log(data);
  //   })
  // }

  reload() {
    this.getAllSanPham();
    console.log(this.getAllSanPham())
    // this.getAllLoHang();
  }
}
