package com.example.demo.service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Province;
import com.example.demo.repository.ProvinceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProvinceServiceImpl implements com.example.demo.service.ProvinceService {
    @Autowired
    private ProvinceRepository provinceRepository;

    @Override
    public Iterable<Province> findAll() {
        return provinceRepository.findAll();
    }

    @Override
    public Province findById(Long id) throws ResourceNotFoundException {
        return provinceRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException(id));
    }

    @Override
    public void save(Province province) {
        provinceRepository.save(province);
    }

    @Override
    public void remove(Long id) {
        provinceRepository.deleteById(id);
    }
}
