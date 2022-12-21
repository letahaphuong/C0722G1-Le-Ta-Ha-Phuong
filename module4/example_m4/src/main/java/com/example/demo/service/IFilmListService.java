package com.example.demo.service;

import com.example.demo.model.FilmList;

import java.util.Optional;

public interface IFilmListService extends IGeneralService<FilmList> {
    Optional<FilmList> findById(String id);
    void remove(String id);
}
