package com.example.controller;

import com.example.service.IConversionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ConversionController {
    @Autowired
    IConversionService conversionService;

    @RequestMapping("")
    public String list(){
        return "/conversion/list";
    }

    @PostMapping("/to-usd")
    public String convertToUsd(double vnd, Model model){
        double result = conversionService.vndToUsd(vnd);
        model.addAttribute("result",result+"$");
        return "/conversion/list";
    }

    @PostMapping("to-vnd")
    public String convertToVnd(double usd, Model model){
        double result = conversionService.usdToVnd(usd);
        model.addAttribute("result",result+"vnd");
        return "/conversion/list";
    }
}
