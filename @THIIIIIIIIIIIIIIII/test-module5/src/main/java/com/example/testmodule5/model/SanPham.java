package com.example.testmodule5.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;

@Entity
public class SanPham {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tenSanPham;
    private String xuatXu;
    private String giaTien;
    private String donVi;

    @OneToMany(mappedBy = "sanPham")
    @JsonBackReference
    private Set<LoHang> loHangs;

    public SanPham() {
    }

    public SanPham(Long id, String tenSanPham, String xuatXu, String giaTien, String donVi, Set<LoHang> loHangs) {
        this.id = id;
        this.tenSanPham = tenSanPham;
        this.xuatXu = xuatXu;
        this.giaTien = giaTien;
        this.donVi = donVi;
        this.loHangs = loHangs;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public String getXuatXu() {
        return xuatXu;
    }

    public void setXuatXu(String xuatXu) {
        this.xuatXu = xuatXu;
    }

    public String getGiaTien() {
        return giaTien;
    }

    public void setGiaTien(String giaTien) {
        this.giaTien = giaTien;
    }

    public String getDonVi() {
        return donVi;
    }

    public void setDonVi(String donVi) {
        this.donVi = donVi;
    }

    public Set<LoHang> getLoHangs() {
        return loHangs;
    }

    public void setLoHangs(Set<LoHang> loHangs) {
        this.loHangs = loHangs;
    }
}
