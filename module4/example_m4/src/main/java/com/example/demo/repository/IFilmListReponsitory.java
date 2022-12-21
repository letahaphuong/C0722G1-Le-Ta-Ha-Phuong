package com.example.demo.repository;

import com.example.demo.model.FilmList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFilmListReponsitory  extends JpaRepository<FilmList,String> {

}
