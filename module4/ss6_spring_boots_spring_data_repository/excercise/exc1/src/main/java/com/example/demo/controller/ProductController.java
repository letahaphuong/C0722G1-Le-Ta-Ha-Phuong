package com.example.demo.controller;

import com.example.demo.model.Product;
import com.example.demo.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    IProductService productService;

    @GetMapping("")
    public String listProduct(Model model){
        List<Product> product=productService.findAll();
       model.addAttribute("productList",product);
       return "product/list";
    }

    @GetMapping("/show-list-create")
    public String listCreate(Model model){
        model.addAttribute("product",new Product());
        return "product/create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("product") Product product, RedirectAttributes redirectAttributes){
        productService.save(product);
        redirectAttributes.addFlashAttribute("mess","Added");
        return "redirect:/product/show-list-create";
    }


}
