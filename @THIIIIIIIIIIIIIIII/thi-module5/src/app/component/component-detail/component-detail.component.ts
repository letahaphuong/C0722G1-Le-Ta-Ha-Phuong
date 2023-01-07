import {Component, Input, OnInit} from '@angular/core';
import {LoHang} from "../model/lo-hang";
import {LoHangDto} from "../model/lo-hang-dto";

@Component({
  selector: 'app-component-detail',
  templateUrl: './component-detail.component.html',
  styleUrls: ['./component-detail.component.css']
})
export class ComponentDetailComponent implements OnInit {
  @Input()
  loHang: LoHangDto = {id: 0};

  constructor() {
  }

  ngOnInit(): void {
  }

}
