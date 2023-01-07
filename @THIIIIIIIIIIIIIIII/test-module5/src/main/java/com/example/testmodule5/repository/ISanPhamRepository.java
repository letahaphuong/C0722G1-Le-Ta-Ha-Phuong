package com.example.testmodule5.repository;

import com.example.testmodule5.model.SanPham;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ISanPhamRepository extends JpaRepository<SanPham,Long> {

    @Query(value = "select * from san_pham", nativeQuery = true)
    List<SanPham> getAllSanPham();
}
