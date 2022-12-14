package com.example.testmodule5.service.impl;

import com.example.testmodule5.dto.LoHangView;
import com.example.testmodule5.model.LoHang;
import com.example.testmodule5.model.SanPham;
import com.example.testmodule5.repository.ILoHangRepository;
import com.example.testmodule5.service.ILoHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoHangService implements ILoHangService {

    @Autowired
    ILoHangRepository loHangRepository;

    @Override
    public List<LoHang> findAll() {
        return loHangRepository.findAll();
    }

    @Override
    public Optional<LoHang> findById(Long id) {
        return loHangRepository.findById(id);
    }

    @Override
    public void save(LoHang loHang) {
        loHangRepository.saveLoHang(loHang.getMaLoHang(),loHang.getNgayHetHan(),loHang.getNgayNhap(), loHang.getNgaySanXuat(), loHang.getSoLuong(), loHang.getSanPham());
    }

    @Override
    public void removeFlag(Long id) {
        loHangRepository.removeFlag(id);
    }

    @Override
    public Page<LoHangView> getAllView( Pageable pageable) {
        return loHangRepository.getAllView(pageable);
    }

//    @Override
//    public LoHang finById(Long id) {
//        return loHangRepository.findById(id).orElse(null);
//    }

    @Override
    public LoHang finById(Long id) {
        return loHangRepository.findByIdSQL(id);
    }

    @Override
    public void update(LoHang loHang) {
        loHangRepository.updateLoHang(loHang.getId(),loHang.getMaLoHang(),loHang.getNgayHetHan(),loHang.getNgayNhap(), loHang.getNgaySanXuat(), loHang.getSoLuong(), loHang.getSanPham());
    }

    @Override
    public Page<LoHangView> searchForField(String ngay1, String ngay2, String tenSanPham, String ngayHetHan, Pageable pageable) {
        return loHangRepository.searchForField(ngay1,ngay2,tenSanPham,ngayHetHan,pageable);
    }
}
