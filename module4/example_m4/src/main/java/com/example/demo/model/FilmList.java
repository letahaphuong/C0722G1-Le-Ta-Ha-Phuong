package com.example.demo.model;

import javax.persistence.*;

@Entity
public class FilmList {

    @Id
    @Column(columnDefinition = "varchar(50)")
    private String showTimeId;

    @ManyToOne
//    @JoinColumn(name = "film_name_id",referencedColumnName = "id")
    private FilmName filmName;

    @Column(columnDefinition = "date")
    private String dateShow;

    private int quantity;

    @Column(columnDefinition = "bit default false")
    private boolean flagDelete;

    public FilmList(String showTimeId, FilmName filmName, String dateShow, int quantity, boolean flagDelete) {
        this.showTimeId = showTimeId;
        this.filmName = filmName;
        this.dateShow = dateShow;
        this.quantity = quantity;
        this.flagDelete = flagDelete;
    }

    public FilmList() {
    }

    public String getShowTimeId() {
        return showTimeId;
    }

    public void setShowTimeId(String showTimeId) {
        this.showTimeId = showTimeId;
    }

    public FilmName getFilmName() {
        return filmName;
    }

    public void setFilmName(FilmName filmName) {
        this.filmName = filmName;
    }

    public String getDateShow() {
        return dateShow;
    }

    public void setDateShow(String dateShow) {
        this.dateShow = dateShow;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isFlagDelete() {
        return flagDelete;
    }

    public void setFlagDelete(boolean flagDelete) {
        this.flagDelete = flagDelete;
    }
}
