package com.example.rom_for_rent.controller;

import com.example.rom_for_rent.model.RoomForRent;
import com.example.rom_for_rent.service.IRoomForRentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;


@Controller
@RequestMapping("room")
public class RoomForRentController {

    @Autowired
    IRoomForRentService roomForRentService;

    @GetMapping("")
    public String showAllList(@RequestParam(defaultValue = "") String search, Model model){
        List<RoomForRent> forRentList=roomForRentService.searchIdAndNameAndPhone(search);
        model.addAttribute("roomList",forRentList);
        return "room/list";
    }

    @GetMapping("/create")
    public String showFormCreate(Model model){
        model.addAttribute("roomForRent",new RoomForRent());
        return "room/create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("roomForRent") RoomForRent roomForRent, RedirectAttributes redirectAttributes){
        roomForRentService.save(roomForRent);
        redirectAttributes.addFlashAttribute("mess","Thêm mới thành công");
        return "redirect:/room/create";
    }

    @PostMapping("/delete")
    public String deleteById(Long id,RedirectAttributes redirectAttributes){
        roomForRentService.remove(id);
        redirectAttributes.addFlashAttribute("mess","Xoá thành công");
        return "redirect:/room";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model){
        model.addAttribute("roomForRent",roomForRentService.findById(id));
        return "room/edit";
    }
}
