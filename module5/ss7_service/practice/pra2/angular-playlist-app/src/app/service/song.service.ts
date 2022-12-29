import {Injectable} from '@angular/core';
import {Song} from '../model/song';

@Injectable({
  providedIn: 'root'
})
export class SongService {
  playlist: Song[] = [
    {
      id: '2OKYsYErfFo',
      name: 'BINZ x ĐEN - CHO MÌNH EM'
    },
    {
      id: 'ZqDBgYPpUTg',
      name: 'YOUR SMILE - Emma'
    },
    {
      id: 'SNES5Y-tYxM',
      name: 'BINZ - OK'
    },
    {
      id: 'KREnGJE0vXQ',
      name: 'Duyên - Huỳnh Tú ft Khói ft Magazine '
    },
    {
      id: 'hIZ2N9hwq4Q',
      name: 'GÁI HUẾ ON ĐỜ MAI | CƯỚI THÔI | MAI KIM LIÊN x HẢI x PHƯƠNG LAN'
    }
  ];


  constructor() {
  }

  findSongById(id: string | null) {
    return this.playlist.find(item => item.id === id);
  }
}
