import {Injectable} from '@angular/core';
import {SanPham} from "../model/san-pham";
import {Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class SanPhamService {
  API_URL_SAN_PHAM = 'http://localhost:8080/san-pham'

  constructor(private http: HttpClient) {
  }

  saveSanPham(sanPham: SanPham): Observable<SanPham> {
    console.log(sanPham)
    return this.http.post<SanPham>(this.API_URL_SAN_PHAM, sanPham)
  }

  getAllSanPham(): Observable<SanPham[]> {
    return this.http.get<SanPham[]>(this.API_URL_SAN_PHAM);
  }
}
