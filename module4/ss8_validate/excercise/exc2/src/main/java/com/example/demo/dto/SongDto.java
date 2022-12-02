package com.example.demo.dto;

import com.example.demo.model.Song;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class SongDto implements Validator {

    private Long id;

    @NotEmpty(message = "{NotEmpty}")
    @Size(min = 0,max = 800,message = "{SizeSongName}")
    @Pattern(regexp = "^([A-Z][a-z]+[ ])+([A-Z][a-z]+)$",message = "{PatternSongName}")
    private String songName;

    @NotEmpty(message = "{NotEmpty}")
    @Size(min = 0,max = 300,message = "{SizeSinger}")
    @Pattern(regexp = "^([A-Z][a-z]+[ ])+([A-Z][a-z]+)$",message = "{PatternSinger}")
    private String singer;

    @NotEmpty(message = "{NotEmpty}")
    @Size(min = 0,max = 1000,message = "{SizeCategory}")
    private String category;

    public SongDto() {
    }

    public SongDto(Long id, @NotEmpty(message = "{NotEmpty}") @Size(min = 0, max = 800, message = "{SizeSongName}") @Pattern(regexp = "^([A-Z][a-z]+[ ])+([A-Z][a-z]+)$", message = "{PatternSongName}") String songName, @NotEmpty(message = "{NotEmpty}") @Size(min = 0, max = 300, message = "{SizeSinger}") @Pattern(regexp = "^([A-Z][a-z]+[ ])+([A-Z][a-z]+)$", message = "{PatternSinger}") String singer, @NotEmpty(message = "{NotEmpty}") @Size(min = 0, max = 1000, message = "{SizeCategory}") String category) {
        this.id = id;
        this.songName = songName;
        this.singer = singer;
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        SongDto songDto = (SongDto) target;
        if (!songDto.getCategory().matches("^[a-zA-Z0-9,]+$")){
            errors.rejectValue("category","PatternCategory","Mặc định");
        }
    }
}
