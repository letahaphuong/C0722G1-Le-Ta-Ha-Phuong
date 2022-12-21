package com.example.demo.repository;

import com.example.demo.model.FilmList;
import com.example.demo.model.FilmName;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFilmNameReponsitory extends JpaRepository<FilmName,Long> {

}
