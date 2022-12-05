package com.example.demo.controller;


import com.example.demo.model.Category;
import com.example.demo.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;


@Controller
@RequestMapping("category")
public class CategoryController {

    @Autowired
    private ICategoryService categoryService;

    @GetMapping("")
    public String showListCategory(Model model,@PageableDefault(page = 0,size = 3)
            Pageable pageable){
        Page<Category> categories=categoryService.findAll(pageable);
        model.addAttribute("categories",categories );
        return "category/list";
    }

    @GetMapping("/show-list-create")
    public String showFormCreate(Model model){
        model.addAttribute("category",new Category());
        return "category/create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("category") Category category, RedirectAttributes redirectAttributes){
        categoryService.save(category);
        redirectAttributes.addFlashAttribute("mess","Added");
        return "redirect:/category/show-list-create";
    }

    @GetMapping("/edit/{id}")
    public String showFormEdit(@PathVariable("id") Long id,Model model){
        model.addAttribute("category",categoryService.findById(id));
        return "/category/edit";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("category") Category category,RedirectAttributes redirectAttributes){
        categoryService.save(category);
        redirectAttributes.addFlashAttribute("mess","Update");
        return "redirect:/category";
    }

    @PostMapping("/delete")
    public String delete(Long id, RedirectAttributes redirectAttributes){
        categoryService.remove(id);
        redirectAttributes.addFlashAttribute("mess","DELETED");
        return "redirect:/category";
    }
}
