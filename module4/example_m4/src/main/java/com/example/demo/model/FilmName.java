package com.example.demo.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class FilmName {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private String filmNameType;

    @OneToMany(mappedBy = "filmName")
    private Set<FilmList> filmLists;

    @ManyToOne
    @JoinColumn(name = "show_time_type_id",referencedColumnName = "id")
    private ShowTimeType showTimeType;

    public FilmName() {
    }

    public FilmName(Long id, String filmNameType, Set<FilmList> filmLists, ShowTimeType showTimeType) {
        this.id = id;
        this.filmNameType = filmNameType;
        this.filmLists = filmLists;
        this.showTimeType = showTimeType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFilmNameType() {
        return filmNameType;
    }

    public void setFilmNameType(String filmNameType) {
        this.filmNameType = filmNameType;
    }

    public Set<FilmList> getFilmLists() {
        return filmLists;
    }

    public void setFilmLists(Set<FilmList> filmLists) {
        this.filmLists = filmLists;
    }

    public ShowTimeType getShowTimeType() {
        return showTimeType;
    }

    public void setShowTimeType(ShowTimeType showTimeType) {
        this.showTimeType = showTimeType;
    }
}
