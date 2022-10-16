CREATE DATABASE IF NOT EXISTS quan_ly_vat_tu;
USE quan_ly_vat_tu;
CREATE TABLE phieu_xuat (
    so_phieu_xuat INT PRIMARY KEY,
    ngay_xuat DATE,
    don_gia_xuat DOUBLE,
    so_luong_xuat INT
);

CREATE TABLE phieu_nhap (
    so_phieu_nhap INT PRIMARY KEY,
    ngay_nhap DATE,
    don_gia_nhap DOUBLE,
    so_luong_nhap INT
);
CREATE TABLE nha_cung_cap (
    ma_nha_cung_cap INT PRIMARY KEY,
    ten_nha_cung_cap VARCHAR(50),
    dia_chi VARCHAR(255),
    sdt VARCHAR(20)
);
CREATE TABLE vat_tu (
    ma_vat_tu INT PRIMARY KEY,
    so_phieu_nhap INT,
    FOREIGN KEY (so_phieu_nhap)
        REFERENCES phieu_nhap (so_phieu_nhap),
    so_phieu_xuat INT,
    FOREIGN KEY (so_phieu_xuat)
        REFERENCES phieu_xuat (so_phieu_xuat),
    ten_vat_tu VARCHAR(50)
);
ALTER TABLE phieu_xuat
ADD COLUMN ma_vat_tu INT;
ALTER TABLE phieu_xuat
ADD FOREIGN KEY (ma_vat_tu) REFERENCES vat_tu(ma_vat_tu);
ALTER TABLE phieu_nhap
ADD COLUMN ma_vat_tu INT;
ALTER TABLE phieu_nhap
ADD FOREIGN KEY (ma_vat_tu) REFERENCES vat_tu(ma_vat_tu);

CREATE TABLE don_hang (
    so_don_dat_hang INT PRIMARY KEY,
    ngay_dat_hang DATE,
    ma_nha_cung_cap INT,
    FOREIGN KEY (ma_nha_cung_cap)
        REFERENCES nha_cung_cap (ma_nha_cung_cap)
);
ALTER TABLE don_hang
ADD COLUMN ma_vat_tu INT AFTER so_don_dat_hang;
ALTER TABLE don_hang
ADD FOREIGN KEY (ma_vat_tu) REFERENCES vat_tu(ma_vat_tu);

ALTER TABLE vat_tu
ADD COLUMN so_don_dat_hang INT;
ALTER TABLE vat_tu
ADD FOREIGN KEY (so_don_dat_hang) REFERENCES don_hang(so_don_dat_hang);