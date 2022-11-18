package com.example.service.impl;

import com.example.service.IConversionService;
import org.springframework.stereotype.Service;

@Service
public class ConversionService implements IConversionService {

    @Override
    public double vndToUsd(double vnd) {
        return vnd/23000;
    }

    @Override
    public double usdToVnd(double usd) {
        return usd*23000;
    }
}
