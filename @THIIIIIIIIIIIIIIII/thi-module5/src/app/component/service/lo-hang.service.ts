import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {LoHang} from "../model/lo-hang";
import {SanPham} from "../model/san-pham";
import {LoHangDto} from "../model/lo-hang-dto";

@Injectable({
  providedIn: 'root'
})
export class LoHangService {
  API_URL_LO_HANG = 'http://localhost:8080/lo-hang'
  API_URL_SAN_PHAM = 'http://localhost:8080/san-pham'

  constructor(private http: HttpClient) {
  }

  // getAll(page: number): Observable<any> {
  //   return this.http.get<any>(this.API_URL_LO_HANG +'?page=' + page);
  // }

  getAll(page: number): Observable<any> {
    return this.http.get<any>(this.API_URL_LO_HANG + '?page=' + page);
  }

  search(ngay1: string, ngay2: string, tenSanPham: string, ngayHetHan: string, page: number): Observable<any> {
    return this.http.get<any>(this.API_URL_LO_HANG + '/search/' + ngay1 + '/' + ngay2 + '/' + tenSanPham + '/' + ngayHetHan + '?page=' + page);
  }

  getAllSanPham(): Observable<any> {
    return this.http.get<any>(this.API_URL_SAN_PHAM)
  }

  saveLoHang(loHang: LoHang): Observable<LoHang> {
    return this.http.post<LoHang>(this.API_URL_LO_HANG, loHang)
  }

  delete(id: number): Observable<LoHang> {
    return this.http.delete<LoHang>(this.API_URL_LO_HANG + '/' + id);
  }

  findById(id: number): Observable<LoHang> {
    return this.http.get<LoHang>(this.API_URL_LO_HANG + '/' + id)
  }

  update(loHang: LoHang): Observable<LoHang> {
    console.log('ser' + loHang)
    return this.http.patch<LoHang>(this.API_URL_LO_HANG + '/' + loHang.id, loHang);
  }
}
