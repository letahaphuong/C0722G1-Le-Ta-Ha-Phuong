package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    IUserService userService;

    @GetMapping("")
    public String showList(Model model) {
        model.addAttribute("userList", userService.findAll());
        return "user/list";
    }

    @GetMapping("/show-list-create")
    public String showListCreate(Model model) {
        model.addAttribute("user", new User());
        return "user/create";
    }

    @PostMapping("/save")
    public String save(@Validated @ModelAttribute("user") User user, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        new User().validate(user, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            return "user/create";
        }
        userService.save(user);
        redirectAttributes.addFlashAttribute("mess", "Added");
        return "redirect:/user/show-list-create";

    }


}
