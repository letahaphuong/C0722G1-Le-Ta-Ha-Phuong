package com.example.rom_for_rent.service.impl;

import com.example.rom_for_rent.model.RoomForRent;
import com.example.rom_for_rent.repository.IRoomForRentRepository;
import com.example.rom_for_rent.service.IRoomForRentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class RoomForRentService implements IRoomForRentService {

    @Autowired
    IRoomForRentRepository roomForRentRepository;

    @Override
    public List<RoomForRent> findAll() {
        return roomForRentRepository.findAll();
    }

    @Override
    public Optional<RoomForRent> findById(Long id) {
        return roomForRentRepository.findById(id);
    }

    @Override
    public void save(RoomForRent roomForRent) {
        roomForRentRepository.save(roomForRent);
    }

    @Override
    public void remove(Long id) {
        roomForRentRepository.deleteById(id);
    }

    @Override
    public Page<RoomForRent> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<RoomForRent> searchIdAndNameAndPhone(String search) {
        return roomForRentRepository.searchIdAndNameAndPhone(search,search);
    }

}
