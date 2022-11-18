package com.example.controller;

import com.example.service.ITranslateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TranslateController {

    @Autowired
    ITranslateService translateService;

    @RequestMapping("")
    public String list(){
        return "/translate/list";
    }

    @PostMapping("/search")
    public String translate(String text, Model model){
    String result=translateService.show(text);
    model.addAttribute("result",result);
    return "/translate/list";
    }
}
