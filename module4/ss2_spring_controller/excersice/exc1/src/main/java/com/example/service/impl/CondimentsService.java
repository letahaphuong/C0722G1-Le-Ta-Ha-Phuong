package com.example.service.impl;

import com.example.repository.ICondimentsRepository;
import com.example.service.ICondimentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CondimentsService implements ICondimentsService {
    @Autowired
    ICondimentsRepository condimentsRepository;
    @Override
    public String showList(String string) {
        return condimentsRepository.showList(string);
    }
}
