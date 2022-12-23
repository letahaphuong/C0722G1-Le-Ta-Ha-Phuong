import {Component, OnInit} from '@angular/core';
import {Color} from "../../model/color";

@Component({
  selector: 'app-color-picker',
  templateUrl: './color-picker.component.html',
  styleUrls: ['./color-picker.component.css']
})
export class ColorPickerComponent implements OnInit {

  col: Color = {
    name: "",
    result: "Màu nè"
  }


  constructor() {
  }

  ngOnInit(): void {
  }

  changeColor(color: string) {
    this.col.name = color;
    // this.col.result = color;
  }
}
