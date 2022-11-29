package com.example.demo.service;

import com.example.demo.model.Song;

import java.util.List;
import java.util.Optional;

public interface ISongService {
    List<Song> findAll();

    Optional<Song> findById(Long id);

    void save(Song song);

    void remove(Long id);
}
