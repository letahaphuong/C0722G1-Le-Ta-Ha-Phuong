package com.example.testmodule5.service;

import com.example.testmodule5.dto.LoHangView;
import com.example.testmodule5.model.LoHang;
import com.example.testmodule5.model.SanPham;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ILoHangService extends IGeneralService<LoHang>{
    Page<LoHangView> getAllView (Pageable pageable);

    LoHang finById(Long id);

    void update(LoHang loHang);

    Page<LoHangView> searchForField(String ngay1,String ngay2,String tenSanPham,String ngayHetHan, Pageable pageable);
}
