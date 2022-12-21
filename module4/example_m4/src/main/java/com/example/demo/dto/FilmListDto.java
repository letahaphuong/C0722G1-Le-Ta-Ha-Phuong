package com.example.demo.dto;

import com.example.demo.model.FilmName;

import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class FilmListDto {

    @NotBlank
    @Pattern(regexp = "^[CI-][0-9]{4}$",message = "{SHOWTIMERCODE}")
    private String showTimeId;

    @NotBlank
    @Pattern(regexp = "^\\p{Lu}\\p{Ll}+(\\s\\p{Lu}\\p{Ll}+)*$",message = "{FILMNAME}")
    private FilmName filmName;

    private String dateShow;

    @NotBlank
    @Pattern(regexp = "^[0-9]+$")
    private int quantity;

    public FilmListDto() {
    }

    public FilmListDto(@NotBlank @Pattern(regexp = "^[CI-][0-9]{4}$", message = "{SHOWTIMERCODE}") String showTimeId, @NotBlank @Pattern(regexp = "^\\p{Lu}\\p{Ll}+(\\s\\p{Lu}\\p{Ll}+)*$", message = "{FILMNAME}") FilmName filmName, String dateShow, @NotBlank @Pattern(regexp = "^[0-9]+$") int quantity) {
        this.showTimeId = showTimeId;
        this.filmName = filmName;
        this.dateShow = dateShow;
        this.quantity = quantity;
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
}
