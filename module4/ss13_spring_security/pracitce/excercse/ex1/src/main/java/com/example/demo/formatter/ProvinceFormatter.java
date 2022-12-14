package com.example.demo.formatter;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Province;
import com.example.demo.formatter.ProvinceFormatter;
import com.example.demo.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class ProvinceFormatter implements Formatter<Province> {

    private ProvinceService provinceService;

    @Autowired
    public ProvinceFormatter(ProvinceService provinceService) {
        this.provinceService = provinceService;
    }

    @Override
    public Province parse(String text, Locale locale){
        try {
            return provinceService.findById(Long.parseLong(text));
        } catch (ResourceNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String print(Province object, Locale locale) {
        return "[" + object.getId() + ", " +object.getName() + "]";

    }
}