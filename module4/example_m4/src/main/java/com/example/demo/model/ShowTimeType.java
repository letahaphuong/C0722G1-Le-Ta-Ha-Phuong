package com.example.demo.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
public class ShowTimeType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private Date showTime;

    @OneToMany(mappedBy = "showTimeType")
    private Set<FilmName> filmNames;

    public ShowTimeType() {
    }

    public ShowTimeType(Long id, Date showTime, Set<FilmName> filmNames) {
        this.id = id;
        this.showTime = showTime;
        this.filmNames = filmNames;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getShowTime() {
        return showTime;
    }

    public void setShowTime(Date showTime) {
        this.showTime = showTime;
    }

    public Set<FilmName> getFilmNames() {
        return filmNames;
    }

    public void setFilmNames(Set<FilmName> filmNames) {
        this.filmNames = filmNames;
    }
}
