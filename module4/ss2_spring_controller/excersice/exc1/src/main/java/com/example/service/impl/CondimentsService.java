package com.example.service.impl;

import com.example.repository.ICondimentsRepository;
import com.example.service.ICondimentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CondimentsService implements ICondimentsService {
    @Autowired
    ICondimentsRepository condimentsRepository;

    @Override
    public List<String> showList(String lettuce, String tomato, String mustard, String sprouts) {
        return condimentsRepository.showList(lettuce,tomato,mustard,sprouts);
    }
}
