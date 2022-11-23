package com.example.controller;

import com.example.service.ICondimentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class CondimentController {

    @Autowired
    ICondimentsService condimentsService;

    @GetMapping("")
    public String showCondiments(){
        return "/condiment/list";
    }

    @PostMapping("/condiment")
    public String showResult(@RequestParam("spice") String[] listSpice,
                             RedirectAttributes redirectAttributes){

       redirectAttributes.addFlashAttribute("listSpice",listSpice);
//    public String showResult(@RequestParam(value = "Lettuce",required = false) String lettuce,
//                             @RequestParam(value = "Tomato",required = false) String tomato,
//                             @RequestParam(value = "Mustard",required = false) String mustard,
//                             @RequestParam(value = "Sprouts",required = false) String sprouts,
//                             Model model){
//        List<String> result =condimentsService.showList(lettuce,tomato,mustard,sprouts);
//        model.addAttribute("result",result);
        return "/condiment/list";
    }
}
