import { Component, OnInit } from '@angular/core';
import {Calculator} from "../../model/calculator";

@Component({
  selector: 'app-calculator',
  templateUrl: './calculator.component.html',
  styleUrls: ['./calculator.component.css']
})
export class CalculatorComponent implements OnInit {

  cal : Calculator ={
    num1:0,
    num2:0,
    result:0
  }

  calResult(calculatoin:string){
    // if (calculatoin=="+"){
    //   this.cal.result=this.cal.num1+this.cal.num2;
    // }else if (calculatoin=="-"){
    //   this.cal.result=this.cal.num1-this.cal.num2;
    // }else if (calculatoin=="*"){
    //   this.cal.result=this.cal.num1*this.cal.num2;
    // }else if (calculatoin=="/"){
    //   this.cal.result=this.cal.num1/this.cal.num2;
    // }

    switch (calculatoin) {
      case "+":
        // this.cal.result=this.cal.num1.valueOf()+this.cal.num2.valueOf();
        this.cal.result=+this.cal.num1 + +this.cal.num2;
          break;
      case "-":
        this.cal.result=this.cal.num1-this.cal.num2;
        break;
      case "*":
        this.cal.result=this.cal.num1*this.cal.num2;
        break;
      case "/":
        this.cal.result=this.cal.num1/this.cal.num2;
        break;
    }
  }

  constructor() { }

  ngOnInit(): void {
  }

}
