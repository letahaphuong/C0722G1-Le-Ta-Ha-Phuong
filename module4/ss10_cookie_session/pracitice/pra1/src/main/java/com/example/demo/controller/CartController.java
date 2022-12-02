package com.example.demo.controller;


import com.example.demo.dto.CartDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping("/cart")
public class CartController {

    @GetMapping("")
    public String showCart(@SessionAttribute("cart")CartDto cartDto,Model model){
        model.addAttribute("cart",cartDto);
        return "cart/list";
    }

    @GetMapping("pay")
    public String remove(@SessionAttribute("cart")CartDto cart, RedirectAttributes redirectAttributes){
        cart.delete();
        redirectAttributes.addFlashAttribute("mess", "Pay successfully");
        return "redirect:/shop";
    }

}
