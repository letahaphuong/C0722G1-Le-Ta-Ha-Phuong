package com.example.demo.service;

import com.example.demo.model.HoKhau;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IHoKhauService extends IGeneralService<HoKhau> {
    Page<HoKhau> showAllHokhau(Pageable pageable);

    void remove(String id);

}
