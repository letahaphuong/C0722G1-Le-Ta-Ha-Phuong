import {Component, OnInit} from '@angular/core';
import {LoHangService} from "../service/lo-hang.service";
import {ToastrService} from "ngx-toastr";
import {ActivatedRoute, Router} from "@angular/router";
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {SanPham} from "../model/san-pham";
import {LoHang} from "../model/lo-hang";

@Component({
  selector: 'app-component-edit',
  templateUrl: './component-edit.component.html',
  styleUrls: ['./component-edit.component.css']
})
export class ComponentEditComponent implements OnInit {

  sanPhams: SanPham[] = [];

  editForm: FormGroup = new FormGroup({
    id: new FormControl(),
    maLoHang: new FormControl('', [Validators.required, Validators.pattern('LH-[0-9]{4}')]),
    sanPham: new FormControl('', [Validators.required]),
    soLuong: new FormControl('', [Validators.required, Validators.min(0)]),
    ngayNhap: new FormControl('', [Validators.required]),
    ngaySanXuat: new FormControl('', [Validators.required]),
    ngayHetHan: new FormControl('', [Validators.required]),
  })

  constructor(private loHangService: LoHangService,
              private toast: ToastrService,
              private router: Router,
              private activatedRoute: ActivatedRoute) {
    this.activatedRoute.paramMap.subscribe(data => {
      const id = data.get('id');
      if (id != null) {
        this.getLoHang(+id);
      }
    })
  }

  ngOnInit(): void {
    this.loHangService.getAllSanPham().subscribe(data => {
      this.sanPhams = data;
    })
  }

  getLoHang(id: number) {
    this.loHangService.findById(id).subscribe(data => {
      console.log('ID .ts' + id);
      console.log(data)
      this.editForm.patchValue(data);
    })
  }

  compareWith(object1: LoHang, object2: LoHang): boolean {
    console.log('id 1 nè:' + object1.id);
    console.log('id 2 nè:' + object2.id);
    return object1 && object2 ? object1.id === object2.id : object1 === object2;
  }

  editLohang() {
    const loHang = this.editForm.value;
    this.loHangService.update(loHang).subscribe(data =>{
      console.log(data)
      this.toast.success('Sửa thành công','Thông báo');
      this.router.navigateByUrl('/')
    },error => {
      this.toast.error('Sửa không thành công','Thông báo');
    })
  }
}
