USE furama_database;

-- 16.	Xóa những Nhân viên chưa từng lập được hợp đồng nào từ năm 2019 đến năm 2021.
SET SQL_SAFE_UPDATES = 0;

DELETE nv.*
FROM
    nhan_vien nv
WHERE
    nv.ma_nhan_vien NOT IN (
    SELECT*FROM(SELECT 
            ma_nhan_vien
        FROM
            hop_dong
        WHERE
            ngay_lam_hop_dong BETWEEN '2019-01-01' AND '2021-12-31') AS x
    );
SET SQL_SAFE_UPDATES = 1;


-- 17.	Cập nhật thông tin những khách hàng có ten_loai_khach từ
-- Platinum lên Diamond, chỉ cập nhật những khách hàng đã từng đặt
-- phòng với Tổng Tiền thanh toán trong năm 2021 là lớn hơn 10.000.000 VNĐ.


UPDATE  
kh.ma_khach_hang,
kh.ho_ten,
(dv.chi_phi + SUM(ifnull(hdct.so_luong,0) * ifnull(dvdk.gia,0))) AS tong_tien,
lk.ma_loai_khach
FROM loai_khach lk 
	JOIN khach_hang kh ON lk.ma_loai_khach = kh.ma_loai_khach
    LEFT JOIN hop_dong hd ON kh.ma_khach_hang = hd.ma_khach_hang
    LEFT JOIN hop_dong_chi_tiet hdct ON hdct.ma_hop_dong = hd.ma_hop_dong
	LEFT JOIN dich_vu_di_kem dvdk ON dvdk.ma_dich_vu_di_kem = hdct.ma_dich_vu_di_kem
    LEFT JOIN dich_vu dv ON hd.ma_dich_vu = dv.ma_dich_vu
    WHERE YEAR(ngay_lam_hop_dong) = '2021'
	GROUP BY kh.ma_khach_hang ;
    
 --    SELECT 
-- kh.ma_khach_hang,
-- kh.ho_ten,
-- (dv.chi_phi + SUM(ifnull(hdct.so_luong,0) * ifnull(dvdk.gia,0))) AS tong_tien,
-- lk.ma_loai_khach
-- FROM loai_khach lk 
-- 	JOIN khach_hang kh ON lk.ma_loai_khach = kh.ma_loai_khach
--     LEFT JOIN hop_dong hd ON kh.ma_khach_hang = hd.ma_khach_hang
--     LEFT JOIN hop_dong_chi_tiet hdct ON hdct.ma_hop_dong = hd.ma_hop_dong
-- 	LEFT JOIN dich_vu_di_kem dvdk ON dvdk.ma_dich_vu_di_kem = hdct.ma_dich_vu_di_kem
--     LEFT JOIN dich_vu dv ON hd.ma_dich_vu = dv.ma_dich_vu
--     WHERE YEAR(ngay_lam_hop_dong) = '2021'
-- 	GROUP BY kh.ma_khach_hang ;

 -- SELECT 
--         hd.ma_hop_dong,
--         dv.ten_dich_vu,
-- 	hd.ngay_lam_hop_dong,
--         hd.ngay_het_thuc,
--         hd.ma_khach_hang,
--         (dv.chi_phi + SUM(ifnull(hdct.so_luong,0) * ifnull(dvdk.gia,0))) AS tong_tien
--     FROM
--         hop_dong hd
--             JOIN
--         dich_vu dv ON hd.ma_dich_vu = dv.ma_dich_vu
-- 			JOIN
--         hop_dong_chi_tiet hdct ON hd.ma_hop_dong = hdct.ma_hop_dong
-- 			JOIN
--         dich_vu_di_kem dvdk ON dvdk.ma_dich_vu_di_kem = hdct.ma_dich_vu_di_kem
-- 			JOIN
-- 		khach_hang kh ON hd.ma_khach_hang = kh.ma_khach_hang
-- 			JOIN
-- 		loai_khach lk ON lk.ma_loai_khach=kh.ma_loai_khach
--     GROUP BY hd.ma_hop_dong
--     HAVING tong_tien > 10000000;
-- 	
