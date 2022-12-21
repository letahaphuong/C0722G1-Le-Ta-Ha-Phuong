package com.example.demo.repository;

import com.example.demo.model.ThanhVien;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IThanhVienRepository extends JpaRepository<ThanhVien,Long> {
}
