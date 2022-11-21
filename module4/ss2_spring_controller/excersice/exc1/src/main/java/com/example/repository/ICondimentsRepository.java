package com.example.repository;


import java.util.List;

public interface ICondimentsRepository {
    List<String> showList(String lettuce,
                          String tomato,
                          String mustard,
                          String sprouts);
}
