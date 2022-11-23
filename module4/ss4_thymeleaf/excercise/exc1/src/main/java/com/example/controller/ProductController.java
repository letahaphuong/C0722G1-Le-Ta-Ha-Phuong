package com.example.controller;

import com.example.model.Product;
import com.example.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    IProductService productService;

    @GetMapping("")
    public String showList(Model model){
        List<Product> productList=productService.findAll();
        model.addAttribute("productList",productList);
        return "product/list";
    }

    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("product",new Product());
        return "product/create";
    }

    @PostMapping("/save")
    public String save(Product product, RedirectAttributes redirectAttributes){
        product.setId((int)(Math.random()*1000));
        productService.save(product);
        redirectAttributes.addFlashAttribute("mess","Added");
        return "redirect:/product/create";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable int id,Model model){
        model.addAttribute("product",productService.findById(id));
        return "product/edit";
    }

    @PostMapping("/update")
    public String update(Product product){
        productService.update(product.getId(),product);
        return "redirect:/product/edit";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable int id,Model model){
        model.addAttribute("product",productService.findById(id));
        return "product/delete";
    }

    @PostMapping("/delete")
    public String delete(Product product,RedirectAttributes redirectAttributes){
        productService.remove(product.getId());
        redirectAttributes.addFlashAttribute("mess","deleted");
        return "redirect:/product";
    }

    @GetMapping("/{id}/view")
    public String view(@PathVariable int id,Model model){
        model.addAttribute("product",productService.findById(id));
        return "product/view";
    }

    @PostMapping("/search")
    public String search(@RequestParam String search,Model model){
        List<Product> productList=productService.findByName(search);
//        model.addAttribute("product",productService.findByName(search));
        model.addAttribute("productList",productList);
        return "product/list";
    }
}
