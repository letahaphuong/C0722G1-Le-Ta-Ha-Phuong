package com.example.demo.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class ThanhVien {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cmnd;

    @Column(columnDefinition = "date")
    private String ngaySinh;

    @OneToMany(mappedBy = "thanhVien")
    private Set<HoKhau> hoKhaus;

    public ThanhVien() {
    }

    public ThanhVien(Long id, String cmnd, String ngaySinh, Set<HoKhau> hoKhaus) {
        this.id = id;
        this.cmnd = cmnd;
        this.ngaySinh = ngaySinh;
        this.hoKhaus = hoKhaus;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCmnd() {
        return cmnd;
    }

    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public Set<HoKhau> getHoKhaus() {
        return hoKhaus;
    }

    public void setHoKhaus(Set<HoKhau> hoKhaus) {
        this.hoKhaus = hoKhaus;
    }
}
