package com.example.demo.service.impl;

import com.example.demo.model.ShowTimeType;
import com.example.demo.repository.IShowTimeTypeReponsitory;
import com.example.demo.service.IShowFilmTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShowFilmTimeService  implements IShowFilmTimeService {

    @Autowired
    IShowTimeTypeReponsitory showTimeTypeReponsitory;
    @Override
    public List<ShowTimeType> findAll() {
        return showTimeTypeReponsitory.findAll();
    }

    @Override
    public Optional<ShowTimeType> findById(Long id) {
        return showTimeTypeReponsitory.findById(id);
    }

    @Override
    public void save(ShowTimeType showTimeType) {
            showTimeTypeReponsitory.save(showTimeType);
    }

    @Override
    public void remove(Long id) {
        showTimeTypeReponsitory.deleteById(id);
    }

    @Override
    public void removeFlag(Long id) {

    }
}
