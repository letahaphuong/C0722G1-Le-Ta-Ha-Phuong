package com.example.repository.impl;

import com.example.repository.ITranslateRepository;
import org.springframework.stereotype.Repository;

@Repository
public class TranslateRepository implements ITranslateRepository {

    private String[] list={"Hello", "World"};
    @Override
    public String show(String word) {
        String result="";
        switch (word){
            case "Hello":
                result="Xin Chào";
                break;
            case "World":
                result="Thế Giới";
                break;
            default:
                result="Không tìm thấy";
        }
        return result;
    }
}
