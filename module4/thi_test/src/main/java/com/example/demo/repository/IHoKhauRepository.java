package com.example.demo.repository;

import com.example.demo.model.HoKhau;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface IHoKhauRepository extends JpaRepository<HoKhau,Long> {

    @Query(value="select * from ho_khau where flag_delete=false",nativeQuery=true)
    Page<HoKhau> showAllHokhau(Pageable pageable);

    @Transactional
    @Modifying
    @Query(value = "update ho_khau c set c.flag_delete = true where c.ma_ho_khau = :id", nativeQuery = true)
    void removeFlag(@Param("id") String id);

}
