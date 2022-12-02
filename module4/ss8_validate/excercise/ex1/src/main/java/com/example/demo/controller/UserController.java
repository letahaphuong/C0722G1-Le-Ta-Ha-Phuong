package com.example.demo.controller;

import com.example.demo.dto.UserDto;
import com.example.demo.dto.UserViewDto;
import com.example.demo.model.User;
import com.example.demo.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    IUserService userService;

    @GetMapping("")
    public String showList(Model model) {
//        model.addAttribute("userList", userService.findAll());
        List<User> user = userService.findAll();
        List<UserViewDto> userViewDto = new ArrayList<>();
        for (int i = 0; i <user.size() ; i++) {
            UserViewDto userViewDto1 = new UserViewDto();
            BeanUtils.copyProperties(user.get(i),userViewDto1);
            userViewDto.add(userViewDto1);
        }
//        BeanUtils.copyProperties(user, userViewDto);
        model.addAttribute("userDtoList",userViewDto );
        return "user/list-dto";
//        return "user/list";
    }

    @GetMapping("/show-list-create")
    public String showListCreate(Model model) {
        model.addAttribute("userDto", new UserDto());
        return "user/create";
    }

    @PostMapping("/save")
    public String save(@Validated @ModelAttribute("userDto") UserDto userDto, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        new UserDto().validate(userDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {

            return "user/create";
        }

        User user = new User();
        BeanUtils.copyProperties(userDto, user);
        userService.save(user);
        redirectAttributes.addFlashAttribute("mess", "Added");
        return "redirect:/user/show-list-create";


    }

    @GetMapping("/edit/{id}")
    public String showFormEdit(@PathVariable("id") Long id, Model model) {

        Optional<User> user = userService.findById(id);

        model.addAttribute("userDto", user.get());
        return "user/edit";
    }

    @PostMapping("/update")
    public String update(@Validated @ModelAttribute("userDto") UserDto userDto, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {

            return "user/edit";
        }
        User user = new User();
        BeanUtils.copyProperties(userDto, user);
        userService.save(user);
        redirectAttributes.addFlashAttribute("mess", "Sửa thành công");
        return "redirect:/user";
    }


}
