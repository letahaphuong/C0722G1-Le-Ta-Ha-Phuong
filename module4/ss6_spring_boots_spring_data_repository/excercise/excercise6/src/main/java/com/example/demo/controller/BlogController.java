package com.example.demo.controller;

import com.example.demo.dto.BlogDto;
import com.example.demo.model.Blog;
import com.example.demo.service.IBlogService;
import com.example.demo.service.ICategoryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;



@Controller
@RequestMapping("blog")
public class BlogController {

    @Autowired
    IBlogService blogService;

    @Autowired
    ICategoryService categoryService;

    @GetMapping("")
    public String showListBlog(@RequestParam(defaultValue = "") String search, Model model,@PageableDefault(page = 0,size = 3) Pageable pageable) {
        Page<Blog> blogList = blogService.searchNameProducerBlog(search,pageable);
        model.addAttribute("blogList", blogList);
        return "blog/list";
    }

    @GetMapping("/show-list-create")
    public String showListCreate(Model model) {
        model.addAttribute("blogDto", new BlogDto());
        model.addAttribute("categoryList",categoryService.findAll());
        return "blog/create";
    }

    @PostMapping("/save")
    public String save(@Validated @ModelAttribute("blogDto") BlogDto blogDto, BindingResult bindingResult, RedirectAttributes redirectAttributes,Model model) {
        if (bindingResult.hasErrors()){
            model.addAttribute("categoryList",categoryService.findAll());
            return "blog/create";
        }
        Blog blog=new Blog();
        BeanUtils.copyProperties(blogDto,blog);

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
        model.addAttribute("categoryList",categoryService.findAll());
        return "/blog/edit";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("blog") Blog blog, RedirectAttributes redirectAttributes) {
        blogService.save(blog);
        redirectAttributes.addFlashAttribute("mess", "Updated");
        return "redirect:/blog";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam Long id, RedirectAttributes redirectAttributes) {
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
