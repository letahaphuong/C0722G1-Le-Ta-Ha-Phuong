package com.example.testmodule5.repository;

import com.example.testmodule5.dto.LoHangView;
import com.example.testmodule5.model.LoHang;
import com.example.testmodule5.model.SanPham;
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


    @Query(value = "select l.id, l.ma_lo_hang maLoHang,s.ten_san_pham tenSanPham,s.gia_tien giaTien,s.don_vi donVi,l.so_luong soLuong,l.ngay_nhap ngayNhap,l.ngay_san_xuat ngaySanXuat,l.ngay_het_han ngayHetHan,l.flag_delete from lo_hang l join san_pham s on l.san_pham_id = s.id where l.flag_delete = false",
            countQuery = "select l.id, l.ma_lo_hang maLoHang,s.ten_san_pham tenSanPham,s.gia_tien giaTien,s.don_vi donVi,l.so_luong soLuong,l.ngay_nhap ngayNhap,l.ngay_san_xuat ngaySanXuat,l.ngay_het_han ngayHetHan,l.flag_delete from lo_hang l join san_pham s on l.san_pham_id = s.id where l.flag_delete = false ",
            nativeQuery = true)
    Page<LoHangView> getAllView(Pageable pageable);

    @Query(value = "select * from lo_hang where id= :id", countQuery = "select * from lo_hang where id= :id", nativeQuery = true)
    LoHang findByIdSQL(@Param("id") Long id);

    @Transactional
    @Modifying
    @Query(value = "update lo_hang l set l.flag_delete = true where l.id = :id", countQuery = "update lo_hang l set l.flag_delete = true where l.id = :id", nativeQuery = true)
    void removeFlag(@Param("id") Long id);

    @Transactional
    @Modifying
    @Query(value = "insert into lo_hang(ma_lo_hang, ngay_het_han, ngay_nhap, ngay_san_xuat, so_luong, san_pham_id)\n" +
            "values (:maLoHang,:ngayHetHan,:ngayNhap,:ngaySanXuat,:soLuong,:sanPham)", countQuery = "insert into lo_hang(ma_lo_hang, ngay_het_han, ngay_nhap, ngay_san_xuat, so_luong, san_pham_id)\n" +
            "values (:maLoHang,:ngayHetHan,:ngayNhap,:ngaySanXuat,:soLuong,:sanPham)", nativeQuery = true)
    void saveLoHang(@Param("maLoHang") String maLoHang, @Param("ngayHetHan") String ngayHetHan, @Param("ngayNhap") String ngayNhap,
                    @Param("ngaySanXuat") String ngaySanXuat, @Param("soLuong") int soLuong, @Param("sanPham") SanPham sanPham);


    @Transactional
    @Modifying
    @Query(value = "update lo_hang\n" +
            "set id = :id,ma_lo_hang = :maLoHang,ngay_het_han = :ngayHetHan, ngay_nhap = :ngayNhap ,ngay_san_xuat = :ngaySanXuat,so_luong = :soLuong,san_pham_id =:sanPham\n" +
            "where id = :id", countQuery = "update lo_hang\n" +
            "set id = :id,ma_lo_hang = :maLoHang,ngay_het_han = :ngayHetHan, ngay_nhap = :ngayNhap ,ngay_san_xuat = :ngaySanXuat,so_luong = :soLuong,san_pham_id =:sanPham\n" +
            "where id = :id", nativeQuery = true)
    void updateLoHang(@Param("id") Long id, @Param("maLoHang") String maLoHang, @Param("ngayHetHan") String ngayHetHan, @Param("ngayNhap") String ngayNhap,
                      @Param("ngaySanXuat") String ngaySanXuat, @Param("soLuong") int soLuong, @Param("sanPham") SanPham sanPham);

    @Query(value = "select l.id, l.ma_lo_hang maLoHang,s.ten_san_pham tenSanPham, s.gia_tien giaTien, s.don_vi donVi, l.so_luong soLuong, l.ngay_nhap ngayNhap, l.ngay_san_xuat ngaySanXuat, l.ngay_het_han  ngayHetHan, l.flag_delete from lo_hang l join san_pham s on l.san_pham_id = s.id where l.ngay_het_han between (ifnull(:ngay1,'') and ifnull( :ngay2,'')) and l.flag_delete = false and (s.ten_san_pham like concat('%', :tenSanPham, '%')) and (l.ngay_het_han like concat('%', :ngayHetHan, '%'))",
            countQuery = "select l.id, l.ma_lo_hang maLoHang,s.ten_san_pham tenSanPham, s.gia_tien giaTien, s.don_vi donVi, l.so_luong soLuong, l.ngay_nhap ngayNhap, l.ngay_san_xuat ngaySanXuat, l.ngay_het_han  ngayHetHan, l.flag_delete from lo_hang l join san_pham s on l.san_pham_id = s.id where l.ngay_het_han between (ifnull(:ngay1,'') and ifnull( :ngay2,'')) and l.flag_delete = false and (s.ten_san_pham like concat('%', :tenSanPham, '%')) and (l.ngay_het_han like concat('%', :ngayHetHan, '%'))", nativeQuery = true)
    Page<LoHangView> searchForField(@Param("ngay1") String ngay1, @Param("ngay2") String ngay2,
                                    @Param("tenSanPham") String tenSanPham, @Param("ngayHetHan") String ngayHetHan,
                                    Pageable pageable);
}
