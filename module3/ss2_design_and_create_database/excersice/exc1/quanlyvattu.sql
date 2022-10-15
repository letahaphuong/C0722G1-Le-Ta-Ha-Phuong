CREATE DATABASE IF NOT EXISTS quan_ly_vattu;
USE quan_ly_vattu;
CREATE TABLE phieu_xuat (
    so_px INT PRIMARY KEY,
    don_gia_xuat VARCHAR(20) PRIMARY KEY,
    so_luong_xuat INT PRIMARY KEY,
    ngay_xuat DATE
);

CREATE TABLE phieu_nhap (
    so_pn INT PRIMARY KEY,
    don_gia_nhap VARCHAR(20) PRIMARY KEY,
    so_luong_nhap INT PRIMARY KEY,
    ngay_nhap DATE
);
CREATE TABLE nha_cc (
    ma_ncc INT PRIMARY KEY,
    ten_ncc VARCHAR(50),
    dia_chi VARCHAR(255),
    sdt VARCHAR(20)
);

CREATE TABLE don_dat_hang (
    ma_ncc INT,
    so_dh INT,
    ten_vat_tu VARCHAR(50),
    ma_vat_tu INT,
    ngay_dat_hang DATE,
    ten_ncc VARCHAR(50),
    dia_chi VARCHAR(255),
    sdt VARCHAR(20),
    PRIMARY KEY (so_dh , ma_ncc , ngay_dat_hang , ten_ncc , dia_chi , sdt , ten_vat_tu , ma_vat_tu),
    FOREIGN KEY (ma_ncc)
        REFERENCES nha_cc (ma_ncc),
    FOREIGN KEY (ngay_dat_hang)
        REFERENCES nha_cc (ngay_dat_hang),
    FOREIGN KEY (ten_ncc)
        REFERENCES nha_cc (ten_ncc),
    FOREIGN KEY (dia_chi)
        REFERENCES nha_cc (dia_chi),
    FOREIGN KEY (sdt)
        REFERENCES nha_cc (sdt),
    FOREIGN KEY (ten_vat_tu)
        REFERENCES vat_tu (ten_vat_tu),
    FOREIGN KEY (ma_vat_tu)
        REFERENCES vat_tu (ma_vat_tu)
);

CREATE TABLE vat_tu (
    ma_vat_tu INT,
    so_dh INT,
    ngay_dat_hang DATE,
    ten_vat_tu VARCHAR(50),
    don_gia_xuat VARCHAR(20),
    so_luong_xuat INT,
    don_gia_nhap VARCHAR(20),
    so_luong_nhap INT,
    PRIMARY KEY(so_dh,ngay_dat_hang),
    FOREIGN KEY(so_dh)REFERENCES don_dat_hang(so_dh),
    FOREIGN KEY(ngay_dat_hang)REFERENCES don_dat_hang(ngay_dat_hang)
);