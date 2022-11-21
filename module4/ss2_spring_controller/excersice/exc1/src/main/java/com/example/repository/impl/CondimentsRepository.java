package com.example.repository.impl;

import com.example.repository.ICondimentsRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CondimentsRepository implements ICondimentsRepository {
    @Override
    public String showList(String string) {
    List<String> listCondiment=new ArrayList<>();
        return null;
    }
}
