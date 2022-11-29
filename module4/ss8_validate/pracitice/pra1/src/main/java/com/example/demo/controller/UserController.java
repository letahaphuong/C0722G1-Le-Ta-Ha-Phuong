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
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping("")
    public String showForm(Model model){
        model.addAttribute("user",new User());
        return "user/list";
    }

//    @PostMapping("/create")
//    public String save(@Validated @ModelAttribute("user") User user, RedirectAttributes redirectAttributes, BindingResult bindingResult){
//       userService.save(user);
//       redirectAttributes.addFlashAttribute("mess","Thêm mới thành công");
//       if (bindingResult.hasFieldErrors()){
//           return "user";
//       }
//       return "redirect:/user";
//    }
    @PostMapping("/create")
    public ModelAndView save(@Validated @ModelAttribute("user") User user, RedirectAttributes redirectAttributes, BindingResult bindingResult){
        userService.save(user);
        redirectAttributes.addFlashAttribute("mess","Thêm mới thành công");
        if (bindingResult.hasFieldErrors()){
            return new ModelAndView("/user/list");
        }
//        return new ModelAndView("redirect:/user");
        return new ModelAndView("/user/result");
    }

}
