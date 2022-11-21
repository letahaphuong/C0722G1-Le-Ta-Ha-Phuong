package com.example.controller;

import com.example.service.ICaculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller

public class ConversionController {
    @Autowired
    ICaculatorService caculatorService;

    @RequestMapping("")
    public String list(){
        return "/caculator/list";
    }

    @PostMapping("/calculate")
    public String division(@RequestParam double x, @RequestParam double y,@RequestParam String operator, Model model){
        double result = caculatorService.calculator(x,y,operator);
        model.addAttribute("result",result);
        return "/caculator/list";
    }


}
