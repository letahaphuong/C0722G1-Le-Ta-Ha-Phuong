package com.example.testmodule5.model;

import javax.persistence.*;

@Entity
public class LoHang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String maLoHang;
    private int soLuong;
    @Column(columnDefinition = "date")
    private String ngayNhap;

    @Column(columnDefinition = "date")
    private String ngaySanXuat;

    @Column(columnDefinition = "date")
    private String ngayHetHan;

    @ManyToOne
    private SanPham sanPham;

    @Column(columnDefinition = "bit default false")
    private boolean flagDelete;

    public LoHang() {
    }

    public LoHang(Long id, String maLoHang, int soLuong, String ngayNhap, String ngaySanXuat, String ngayHetHan, SanPham sanPham, boolean flagDelete) {
        this.id = id;
        this.maLoHang = maLoHang;
        this.soLuong = soLuong;
        this.ngayNhap = ngayNhap;
        this.ngaySanXuat = ngaySanXuat;
        this.ngayHetHan = ngayHetHan;
        this.sanPham = sanPham;
        this.flagDelete = flagDelete;
    }

    public boolean isFlagDelete() {
        return flagDelete;
    }

    public void setFlagDelete(boolean flagDelete) {
        this.flagDelete = flagDelete;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMaLoHang() {
        return maLoHang;
    }

    public void setMaLoHang(String maLoHang) {
        this.maLoHang = maLoHang;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(String ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

    public String getNgaySanXuat() {
        return ngaySanXuat;
    }

    public void setNgaySanXuat(String ngaySanXuat) {
        this.ngaySanXuat = ngaySanXuat;
    }

    public String getNgayHetHan() {
        return ngayHetHan;
    }

    public void setNgayHetHan(String ngayHetHan) {
        this.ngayHetHan = ngayHetHan;
    }

    public SanPham getSanPham() {
        return sanPham;
    }

    public void setSanPham(SanPham sanPham) {
        this.sanPham = sanPham;
    }
}
