package com.example.testmodule5.repository;

import com.example.testmodule5.dto.LoHangView;
import com.example.testmodule5.model.LoHang;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ILoHangRepository extends JpaRepository<LoHang, Long> {

//    @Query(value = "select l.id, l.ma_lo_hang maLoHang,s.ten_san_pham tenSanPham,s.gia_tien giaTien,s.don_vi donVi,l.so_luong soLuong,l.ngay_nhap ngayNhap,l.ngay_san_xuat ngaySanXuat,l.ngay_het_han ngayHetHan,l.flag_delete from lo_hang l\n" +
//            "join san_pham s on l.san_pham_id = s.id where l.flag_delete = false and (s.ten_san_pham like concat('%' , :tenSanPham , '%'))",
//            countQuery = "select l.id, l.ma_lo_hang maLoHang,s.ten_san_pham tenSanPham,s.gia_tien giaTien,s.don_vi donVi,l.so_luong soLuong,l.ngay_nhap ngayNhap,l.ngay_san_xuat ngaySanXuat,l.ngay_het_han ngayHetHan,l.flag_delete from lo_hang l\n" +
//                    "join san_pham s on l.san_pham_id = s.id where l.flag_delete = false and (s.ten_san_pham like concat('%' , :tenSanPham , '%'))",
//            nativeQuery = true)
//    Page<LoHangView> getAllView(@Param("tenSanPham") String tenSanPham, Pageable pageable);

    @Query(value = "select l.id, l.ma_lo_hang maLoHang,s.ten_san_pham tenSanPham,s.gia_tien giaTien,s.don_vi donVi,l.so_luong soLuong,l.ngay_nhap ngayNhap,l.ngay_san_xuat ngaySanXuat,l.ngay_het_han ngayHetHan,l.flag_delete from lo_hang l join san_pham s on l.san_pham_id = s.id where l.flag_delete = false",
            countQuery = "select l.id, l.ma_lo_hang maLoHang,s.ten_san_pham tenSanPham,s.gia_tien giaTien,s.don_vi donVi,l.so_luong soLuong,l.ngay_nhap ngayNhap,l.ngay_san_xuat ngaySanXuat,l.ngay_het_han ngayHetHan,l.flag_delete from lo_hang l join san_pham s on l.san_pham_id = s.id where l.flag_delete = false ",
            nativeQuery = true)
    Page<LoHangView> getAllView(Pageable pageable);

    @Transactional
    @Modifying
    @Query(value = "update lo_hang l set l.flag_delete = true where l.id = :id",countQuery = "update lo_hang l set l.flag_delete = true where l.id = :id", nativeQuery = true)
    void removeFlag(@Param("id") Long id);
}
