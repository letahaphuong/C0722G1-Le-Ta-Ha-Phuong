package com.example.controller;

import com.example.model.Login;
import com.example.model.User;
import com.example.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
    @Autowired
    IUserService userService;

    @GetMapping("")
    public String showFormLogin(Model model){
        model.addAttribute("login",new Login());
        return "/home";
    }


    @PostMapping("/login")
    public ModelAndView login(@ModelAttribute("login") Login login){
        User user = userService.checkLogin(login);
        if(user == null){
            ModelAndView modelAndView = new ModelAndView("/error");
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("/user");
            modelAndView.addObject("user", user);
            return modelAndView;
        }
    }
//    public String login(@ModelAttribute("login") Login login){
//        User user=userService.checkLogin(login);
//        String result="";
//        if (user==null){
//            result="Error";
//        }else {
//        }
//        return null;
//    }
}
