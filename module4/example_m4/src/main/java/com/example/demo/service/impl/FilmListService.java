package com.example.demo.service.impl;

import com.example.demo.model.FilmList;
import com.example.demo.repository.IFilmListReponsitory;
import com.example.demo.service.IFilmListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FilmListService implements IFilmListService {

    @Autowired
    IFilmListReponsitory filmListReponsitory;

    @Override
    public List<FilmList> findAll() {
        return filmListReponsitory.findAll();
    }

    @Override
    public Optional<FilmList> findById(Long id) {
        return null;
    }

    @Override
    public void save(FilmList filmList) {
        filmListReponsitory.save(filmList);
    }

    @Override
    public void remove(Long id) {

    }

    @Override
    public void removeFlag(Long id) {
    }

    @Override
    public Optional<FilmList> findById(String id) {
        return filmListReponsitory.findById(id);
    }

    @Override
    public void remove(String id) {
        filmListReponsitory.deleteById(id);
    }
}
