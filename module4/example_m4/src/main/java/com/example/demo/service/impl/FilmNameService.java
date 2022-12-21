package com.example.demo.service.impl;

import com.example.demo.model.FilmName;
import com.example.demo.repository.IFilmNameReponsitory;
import com.example.demo.service.IFilmNameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FilmNameService implements IFilmNameService {

    @Autowired
    IFilmNameReponsitory filmNameReponsitory;

    @Override
    public List<FilmName> findAll() {
        return filmNameReponsitory.findAll();
    }

    @Override
    public Optional<FilmName> findById(Long id) {
        return filmNameReponsitory.findById(id);
    }

    @Override
    public void save(FilmName filmName) {
            filmNameReponsitory.save(filmName);
    }

    @Override
    public void remove(Long id) {
        filmNameReponsitory.deleteById(id);
    }

    @Override
    public void removeFlag(Long id) {

    }
}
