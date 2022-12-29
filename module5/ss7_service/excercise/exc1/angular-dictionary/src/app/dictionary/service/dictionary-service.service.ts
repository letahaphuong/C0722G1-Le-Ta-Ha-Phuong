import {Injectable} from '@angular/core';
import {IWord} from '../i-word';
import {element} from 'protractor';

@Injectable({
  providedIn: 'root'
})
export class DictionaryServiceService {
  iWords: IWord[] = [
    {
      word: 'helo',
      mean: 'xin chào'
    },
    {
      word: 'year',
      mean: 'năm',
    },
    {
      word: 'thanks',
      mean: 'cảm ơn'
    }
  ];

  constructor() {
  }

  // tslint:disable-next-line:typedef
  getAll() {
    return this.iWords;
  }

  findWord(w: string | null): IWord | null {
    // tslint:disable-next-line:no-shadowed-variable
    const temp = this.iWords.filter(element => element.word === w);
    if (temp.length === 0) {
      return null;
    }
    return temp[0];
  }
}
