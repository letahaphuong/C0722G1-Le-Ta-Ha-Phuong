package com.example.rom_for_rent.service;

import com.example.rom_for_rent.model.RoomForRent;
import org.springframework.data.domain.Page;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

public interface IGeneralService<T> {
    List<T> findAll();

    Optional<T> findById(Long id);

    void save(T t);

    void remove(Long id);

    Page<RoomForRent> findAll(Pageable pageable);

    List<RoomForRent> searchIdAndNameAndPhone(String search);
}
