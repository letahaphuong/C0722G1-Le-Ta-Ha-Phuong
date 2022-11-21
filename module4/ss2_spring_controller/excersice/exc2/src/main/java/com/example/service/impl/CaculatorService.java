package com.example.service.impl;

import com.example.service.ICaculatorService;
import org.springframework.stereotype.Service;

@Service
public class CaculatorService implements ICaculatorService {

    @Override
    public double calculator(double addition1, double addition2, String operator) {
        double result;
        switch (operator){
            case "addition":
                result=addition1+addition2;
                break;
            case "subtraction":
                result=addition1-addition2;
                break;
            case "multiplication":
                result=addition1*addition2;
                break;
            case "division":
                result=addition1/addition2;
                break;
            default:
                result=0;
                break;
        }
        return result;
    }
}
