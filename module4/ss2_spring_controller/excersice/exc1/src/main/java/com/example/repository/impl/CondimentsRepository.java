package com.example.repository.impl;

import com.example.repository.ICondimentsRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CondimentsRepository implements ICondimentsRepository {

    @Override
    public List<String> showList(String lettuce, String tomato, String mustard, String sprouts) {
        List<String> listCondiment = new ArrayList<>();
        if (lettuce != null) {
            listCondiment.add(lettuce);
        }
        if (tomato != null) {
            listCondiment.add(tomato);
        }
        if (mustard != null) {
            listCondiment.add(mustard);
        }
        if (sprouts != null) {
            listCondiment.add(sprouts);
        }
        return listCondiment;
    }
}
