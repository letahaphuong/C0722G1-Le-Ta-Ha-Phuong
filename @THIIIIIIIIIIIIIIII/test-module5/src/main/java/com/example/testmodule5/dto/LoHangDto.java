package com.example.testmodule5.dto;

import com.example.testmodule5.model.SanPham;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class LoHangDto {
    private Long id;
    @NotBlank
    @Pattern(regexp = "LH-[0-9]{4}",message = "Sai định dạng.")
    private String maLoHang;

    @NotBlank
    @Min(value = 0,message = "Số lượng phải lớn hơn 0")
    private int soLuong;

    @NotBlank
    private String ngayNhap;

    @NotBlank
    private String ngaySanXuat;

    @NotBlank
    private String ngayHetHan;

    @NotBlank
    private SanPham sanPham;


    private boolean flagDelete;

    public LoHangDto() {
    }

    public LoHangDto(Long id, String maLoHang, int soLuong, String ngayNhap, String ngaySanXuat, String ngayHetHan, SanPham sanPham, boolean flagDelete) {
        this.id = id;
        this.maLoHang = maLoHang;
        this.soLuong = soLuong;
        this.ngayNhap = ngayNhap;
        this.ngaySanXuat = ngaySanXuat;
        this.ngayHetHan = ngayHetHan;
        this.sanPham = sanPham;
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

    public boolean isFlagDelete() {
        return flagDelete;
    }

    public void setFlagDelete(boolean flagDelete) {
        this.flagDelete = flagDelete;
    }
}
