package com.example.service;

import java.util.List;

public interface ICondimentsService {
    List<String> showList(String lettuce,
                          String tomato,
                          String mustard,
                          String sprouts);

}
