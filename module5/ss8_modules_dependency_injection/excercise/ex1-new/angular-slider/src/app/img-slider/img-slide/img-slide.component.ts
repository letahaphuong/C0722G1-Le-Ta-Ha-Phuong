import {Component, OnInit} from '@angular/core';
import {Img} from '../img';

@Component({
  selector: 'app-img-slide',
  templateUrl: './img-slide.component.html',
  styleUrls: ['./img-slide.component.css']
})
export class ImgSlideComponent implements OnInit {
  n = 0;
  img?: Img[] = [
    {
      id: 1,
      link: 'https://vcdn1-dulich.vnecdn.net/2021/07/16/8-1626444967.jpg?w=1200&h=0&q=100&dpr=1&fit=crop&s=GfgGn4dNuKZexy1BGkAUNA'
    },
    {
      id: 2,
      link: 'https://znews-photo.zingcdn.me/w660/Uploaded/mdf_eioxrd/2021_07_06/10.jpg'
    },
    {id: 3,
      link: 'https://cdn.baogiaothong.vn/upload/2-2022/images/2022-05-25/1-1653445668-308-width740height476.jpg'
    },
    {
      id: 4,
      link: 'https://cdn.baogiaothong.vn/upload/2-2022/images/2022-05-25/4-1653445668-151-width740height377.jpg'
    }
  ];
  size: number | undefined = this.img?.length;

  constructor() {
  }

  ngOnInit(): void {
  }

  previous(): void {
    if (this.n < this.size - 1) {
      this.n = this.n + 1;
    }
  }

  back(): void {
    if (this.n > 0) {
      this.n = this.n - 1;
    }
  }

}
