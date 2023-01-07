import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {LoHang} from "../model/lo-hang";
import {LoHangService} from "../service/lo-hang.service";
import {ToastrService} from "ngx-toastr";
import {LoHangDto} from "../model/lo-hang-dto";

@Component({
  selector: 'app-component-delete',
  templateUrl: './component-delete.component.html',
  styleUrls: ['./component-delete.component.css']
})
export class ComponentDeleteComponent implements OnInit {
  @Input()
  loHang: LoHangDto = {id: 0}

  @Output()
  eventDelete = new EventEmitter();

  constructor(private loHangService: LoHangService, private toast: ToastrService) {
  }

  ngOnInit(): void {
  }

  delete() {
    const id = this.loHang.id;
    this.loHangService.delete(id).subscribe(data => {
      this.eventDelete.emit();
      this.toast.success('Xoá thành công', 'Thông báo')
    }, error => {
      this.toast.error('Xoá không thành công', 'Thông báo');
    })
  }
}
