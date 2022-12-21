package com.example.demo.model;

import javax.persistence.*;

@Entity
public class HoKhau {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String maHoKhau;

    private String tenChuHo;

    private int soLuongThanhVien;

    @Column(columnDefinition = "date")
    private String ngayLapHoKhau;

    private String diaChi;

    @Column(columnDefinition = "bit default false")
    private boolean flagDelete;

    @ManyToOne
    private ThanhVien thanhVien;

    public HoKhau() {
    }

    public HoKhau(Long id, String maHoKhau, String tenChuHo, int soLuongThanhVien, String ngayLapHoKhau, String diaChi, boolean flagDelete, ThanhVien thanhVien) {
        this.id = id;
        this.maHoKhau = maHoKhau;
        this.tenChuHo = tenChuHo;
        this.soLuongThanhVien = soLuongThanhVien;
        this.ngayLapHoKhau = ngayLapHoKhau;
        this.diaChi = diaChi;
        this.flagDelete = flagDelete;
        this.thanhVien = thanhVien;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMaHoKhau() {
        return maHoKhau;
    }

    public void setMaHoKhau(String maHoKhau) {
        this.maHoKhau = maHoKhau;
    }

    public String getTenChuHo() {
        return tenChuHo;
    }

    public void setTenChuHo(String tenChuHo) {
        this.tenChuHo = tenChuHo;
    }

    public int getSoLuongThanhVien() {
        return soLuongThanhVien;
    }

    public void setSoLuongThanhVien(int soLuongThanhVien) {
        this.soLuongThanhVien = soLuongThanhVien;
    }

    public String getNgayLapHoKhau() {
        return ngayLapHoKhau;
    }

    public void setNgayLapHoKhau(String ngayLapHoKhau) {
        this.ngayLapHoKhau = ngayLapHoKhau;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public boolean isFlagDelete() {
        return flagDelete;
    }

    public void setFlagDelete(boolean flagDelete) {
        this.flagDelete = flagDelete;
    }

    public ThanhVien getThanhVien() {
        return thanhVien;
    }

    public void setThanhVien(ThanhVien thanhVien) {
        this.thanhVien = thanhVien;
    }
}
