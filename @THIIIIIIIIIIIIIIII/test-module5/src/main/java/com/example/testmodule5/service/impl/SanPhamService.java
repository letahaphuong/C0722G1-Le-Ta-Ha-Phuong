package com.example.testmodule5.service.impl;

import com.example.testmodule5.model.SanPham;
import com.example.testmodule5.repository.ISanPhamRepository;
import com.example.testmodule5.service.ISanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SanPhamService implements ISanPhamService {

    @Autowired
    ISanPhamRepository sanPhamRepository;

    @Override
    public List<SanPham> findAll() {
        return sanPhamRepository.getAllSanPham();
    }

    @Override
    public Optional<SanPham> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public void save(SanPham sanPham) {
            sanPhamRepository.save(sanPham);
    }

    @Override
    public void removeFlag(Long id) {

    }
}
