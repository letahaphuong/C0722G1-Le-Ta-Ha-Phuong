package com.example.demo.repository;

import com.example.demo.model.FilmList;
import com.example.demo.model.ShowTimeType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IShowTimeTypeReponsitory extends JpaRepository<ShowTimeType,Long> {

}
