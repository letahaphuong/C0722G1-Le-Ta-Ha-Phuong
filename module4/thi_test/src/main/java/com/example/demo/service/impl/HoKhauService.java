package com.example.demo.service.impl;

import com.example.demo.model.HoKhau;
import com.example.demo.repository.IHoKhauRepository;
import com.example.demo.service.IHoKhauService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HoKhauService implements IHoKhauService {

    @Autowired
    IHoKhauRepository hoKhauRepository;

    @Override
    public List<HoKhau> findAll() {
        return hoKhauRepository.findAll();
    }

    @Override
    public Optional<HoKhau> findById(Long id) {
        return hoKhauRepository.findById(id);
    }

    @Override
    public void save(HoKhau hoKhau) {
        hoKhauRepository.save(hoKhau);
    }

    @Override
    public void remove(Long id) {

    }

    @Override
    public void removeFlag(Long id) {

    }

    @Override
    public Page<HoKhau> showAllHokhau(Pageable pageable) {
        return hoKhauRepository.showAllHokhau(pageable);
    }

    @Override
    public void remove(String id) {
        hoKhauRepository.removeFlag(id);
    }
}
