package com.example.demo.controller;

import com.example.demo.model.HoKhau;
import com.example.demo.service.IHoKhauService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("hokhau")
public class HoKhauController {

    @Autowired
    IHoKhauService hoKhauService;

    @GetMapping("")
    public String danhSachHoKhau(Model model,@PageableDefault(page = 0, size = 3) Pageable pageable){
        model.addAttribute("danhSachHoKhau",hoKhauService.showAllHokhau(pageable));
        return "example/list";
    }

    @PostMapping("/delete")
    public String xoaHoKhau(@RequestParam String id, RedirectAttributes redirectAttributes){
        hoKhauService.remove(id);
        redirectAttributes.addFlashAttribute("mess","Xoá Thành công");
        return "redirect:/hokhau";
    }

    @GetMapping("/edit/{id}")
    public String suaHoKhau(@PathVariable("id") Long id,Model model){
        model.addAttribute("hoKhau",hoKhauService.findById(id).get());
        return "example/edit";
    }

    @PostMapping("update")
    public String update(@ModelAttribute HoKhau hoKhau,RedirectAttributes redirectAttributes){
        hoKhauService.save(hoKhau);
        redirectAttributes.addFlashAttribute("mess","Sửa Thành công");
        return "redirect:/hokhau";
    }
}
