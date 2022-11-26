package com.example.demo.controller;

import com.example.demo.model.Blog;
import com.example.demo.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("blog")
public class BlogController {

    @Autowired
    IBlogService blogService;

    @GetMapping("")
    public String showListBlog(@RequestParam(defaultValue = "") String search, Model model) {
        List<Blog> blogList = blogService.searchNameContentAndProducerBlog(search);
        model.addAttribute("blogList", blogList);
        return "blog/list";
    }

    @GetMapping("/show-list-create")
    public String showListCreate(Model model) {
        model.addAttribute("blog", new Blog());
        return "blog/create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("blog") Blog blog, RedirectAttributes redirectAttributes) {
        blogService.save(blog);
        redirectAttributes.addFlashAttribute("mess", "Added");
        return "redirect:/blog/show-list-create";
    }

//    @GetMapping("/edit/{id}")
//    public ModelAndView showFormEdit(@PathVariable("id") Long id) {
//        Optional<Blog> blog = blogService.findById(id);
//            ModelAndView modelAndView = new ModelAndView("/blog/edit");
//            modelAndView.addObject("blog", blog.get());
//            return modelAndView;
//    }

    @GetMapping("/edit/{id}")
    public String showFormEdit(@PathVariable("id") Long id,Model model) {
        model.addAttribute("blog",blogService.findById(id));
        return "/blog/edit";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("blog") Blog blog, RedirectAttributes redirectAttributes) {
        blogService.save(blog);
        redirectAttributes.addFlashAttribute("mess", "Updated");
        return "redirect:/blog";
    }

    @PostMapping("/delete")
    public String delete(Long id, RedirectAttributes redirectAttributes) {
        blogService.remove(id);
        redirectAttributes.addFlashAttribute("mess", "deleted");
        return "redirect:/blog";
    }

//    @GetMapping("/view/{id}")
//    public ModelAndView viewAllBlog(@PathVariable("id") Long id) {
//        Optional<Blog> blog = blogService.findById(id);
//        ModelAndView modelAndView = new ModelAndView("/blog/view");
//        modelAndView.addObject("blog", blog.get());
//        return modelAndView;
//    }

    @GetMapping("/view/{id}")
    public String viewAllBlog(@PathVariable("id") Long id,Model model) {
        model.addAttribute("blog",blogService.findById(id));
        return "blog/view";
    }

}
