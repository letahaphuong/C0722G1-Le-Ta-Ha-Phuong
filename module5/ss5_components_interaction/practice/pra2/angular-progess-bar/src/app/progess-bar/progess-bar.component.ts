import {Component, Input, OnInit} from '@angular/core';

@Component({
  selector: 'app-progess-bar',
  templateUrl: './progess-bar.component.html',
  styleUrls: ['./progess-bar.component.css']
})
export class ProgessBarComponent implements OnInit {
  @Input() backgroudColor = '#D9D9D9';
  @Input() progressColor = '#4CAF50';
  @Input() progress = 0;
  constructor() { }

  ngOnInit(): void {
    this.loading();
  }

  // tslint:disable-next-line:typedef
  loading(){
   const interval = setInterval(() => {
     this.progress = +this.progress + 5;
     if (this.progress === 100){
       clearInterval(interval);
     }
   }, 1000);
  }
}
