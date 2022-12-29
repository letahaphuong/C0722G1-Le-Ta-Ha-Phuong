import {Component, OnInit} from '@angular/core';
import {IWord} from '../i-word';
import {DictionaryServiceService} from '../service/dictionary-service.service';
import {ActivatedRoute} from '@angular/router';

@Component({
  selector: 'app-dictionary-list',
  templateUrl: './dictionary-list.component.html',
  styleUrls: ['./dictionary-list.component.css']
})
export class DictionaryListComponent implements OnInit {
  iWord: IWord | null = {};
  iWordShow: IWord[] = [];

  constructor(private dictionaryServiceService: DictionaryServiceService, private activatedRoute: ActivatedRoute) {
    this.activatedRoute.paramMap.subscribe(data => {
      const word = data.get('word');
      this.iWord = this.dictionaryServiceService.findWord(word);
    }, error => {

    }, () => {
    });
  }

  ngOnInit(): void {
    this.getAll();
  }

  // tslint:disable-next-line:typedef
  getAll() {
    this.iWordShow = this.dictionaryServiceService.getAll();
  }
}
