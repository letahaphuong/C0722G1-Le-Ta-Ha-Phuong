USE furama_database;

-- 16.	Xóa những Nhân viên chưa từng lập được hợp đồng nào từ năm 2019 đến năm 2021.
SET SQL_SAFE_UPDATES = 0;

DELETE
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

