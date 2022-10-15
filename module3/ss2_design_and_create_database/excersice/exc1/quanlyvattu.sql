CREATE DATABASE IF NOT EXISTS quan_ly_vattu;
USE quan_ly_vattu;
CREATE TABLE phieu_xuat (
    so_px INT PRIMARY KEY,
    don_gia_xuat VARCHAR(20),
    so_luong_xuat INT ,
    ngay_xuat DATE 
);



CREATE TABLE phieu_nhap (
    so_pn INT PRIMARY KEY,
    don_gia_nhap VARCHAR(20),
    so_luong_nhap INT ,
    ngay_nhap DATE 
);
CREATE TABLE nha_cc (
    ma_ncc INT PRIMARY KEY,
    ten_ncc VARCHAR(50) ,
    dia_chi VARCHAR(255) ,
    sdt VARCHAR(20) 
);

CREATE TABLE don_dh (
    so_dh INT PRIMARY KEY,
    ngay_dh DATE ,
    ma_ncc INT ,
    FOREIGN KEY (ma_ncc)
        REFERENCES nha_cc (ma_ncc)
);
CREATE TABLE vat_tu (
    ma_vat_tu INT PRIMARY KEY,
    ten_vat_tu VARCHAR(50),
    don_gia_xuat VARCHAR(20),
    so_dh INT,
    FOREIGN KEY (so_dh)
        REFERENCES don_dh (so_dh),
    so_px INT,
    FOREIGN KEY (so_px)
        REFERENCES phieu_xuat (so_px),
    so_pn INT,
    FOREIGN KEY (so_pn)
        REFERENCES phieu_nhap (so_pn)
);