package com.example.demo.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @NotEmpty(message = "{NotEmpty}")
//    @Size(min = 0,max = 800,message = "{SizeSongName}")
//    @Pattern(regexp = "^([A-Z][a-z]+[ ])+([A-Z][a-z]+)$",message = "{PatternSongName}")
    private String songName;

//    @NotEmpty(message = "{NotEmpty}")
//    @Size(min = 0,max = 300,message = "{SizeSinger}")
//    @Pattern(regexp = "^([A-Z][a-z]+[ ])+([A-Z][a-z]+)$",message = "{PatternSinger}")
    private String singer;

//    @NotEmpty(message = "{NotEmpty}")
//    @Size(min = 0,max = 1000,message = "{SizeCategory}")
    private String category;

    public Song() {
    }

    public Song(Long id, String songName, String singer, String category) {
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

//    @Override
//    public boolean supports(Class<?> clazz) {
//        return false;
//    }
//
//    @Override
//    public void validate(Object target, Errors errors) {
//        Song song= (Song) target;
//        if (!song.getCategory().matches("^[a-zA-Z0-9,]+$")){
//            errors.rejectValue("category","PatternCategory","Mặc định");
//        }
//    }
}
