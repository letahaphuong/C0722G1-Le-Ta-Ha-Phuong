package com.example.demo.controller;

import com.example.demo.dto.CartDto;
import com.example.demo.dto.ProductDto;
import com.example.demo.model.Product;
import com.example.demo.service.IProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

@Controller
@RequestMapping("shop")
@SessionAttributes("cart") // B1 : khai báo session
public class ProductController {

    @Autowired
    private IProductService productService;

    @ModelAttribute("cart")// khởi tạo giá trị ban đầu cho ss
    public CartDto initCart() {
        return new CartDto();
    }


    @GetMapping("/add/{id}")
    public String addToCart(@PathVariable("id") Long id, @SessionAttribute("cart") CartDto cartDto) {
        Optional<Product> product = productService.findById(id);
        ProductDto productDto = new ProductDto();
        BeanUtils.copyProperties(product.get(), productDto);
        cartDto.addProduct(productDto);
        return "redirect:/cart";

    }

    @GetMapping("/detail/{id}")
    public String showDetail(@PathVariable("id") long id, HttpServletResponse response,
                             Model model) {
        Cookie cookie = new Cookie("idProduct", String.valueOf(id));
        cookie.setMaxAge(30);
        cookie.setPath("/");
        response.addCookie(cookie);

        model.addAttribute("product", productService.findById(id).get());
        return "product/detail";
    }

    @GetMapping("")
    public String showListPage(Model model, @CookieValue(value = "idProduct"
            , defaultValue = "-1") Long idProduct) {
        if (idProduct != -1) {
            model.addAttribute("historyProduct", productService.findById(idProduct).get());
        }

        model.addAttribute("productList", productService.findAll());
        return "product/list";
//        if (idProduct != -1) {
//            model.addAttribute("historyProduct", productService.findById(idProduct).get());
//        }
    }

}
