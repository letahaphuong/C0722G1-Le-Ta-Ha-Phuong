package com.example.demo.controller;

import com.example.demo.model.PhoneNumber;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("phone")
public class PhoneController {

    @GetMapping("")
    public String showForm(Model model){
        model.addAttribute("phoneNumber",new PhoneNumber());
        return "phone/index";
    }

    @PostMapping("")
    public String checkValidation(@Validated @ModelAttribute("phoneNumber") PhoneNumber phoneNumber,Model model, BindingResult bindingResult){
        new PhoneNumber().validate(phoneNumber,bindingResult);
        if (bindingResult.hasFieldErrors()){
            return "phone/index";
        }
        else {
            model.addAttribute("phoneNumber",phoneNumber);
            return "phone/view";
        }
    }
}
