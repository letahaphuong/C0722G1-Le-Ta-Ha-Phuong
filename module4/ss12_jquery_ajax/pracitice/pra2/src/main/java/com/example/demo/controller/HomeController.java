package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.print.DocFlavor;

@Controller
public class HomeController {
    @GetMapping("")
    public String showIndex(){
        return "/index";
    }
}
