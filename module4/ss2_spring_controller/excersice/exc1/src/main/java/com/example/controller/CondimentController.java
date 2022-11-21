package com.example.controller;

import com.example.service.ICondimentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CondimentController {

    @Autowired
    ICondimentsService condimentsService;

    @GetMapping("")
    public String showCondiments(){
        return "/list";
    }

    @PostMapping("/condiments")
    public String showResult(@RequestParam("Lettuce") String lettuce,
                             @RequestParam("Tomato") String tomato,
                             @RequestParam("Mustard") String mustard,
                             @RequestParam("Sprouts") String sprouts,
                             Model model){
        

    }
}
