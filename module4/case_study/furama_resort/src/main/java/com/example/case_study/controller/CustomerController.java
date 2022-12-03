package com.example.case_study.controller;

import com.example.case_study.model.customer.Customer;
import com.example.case_study.service.customer.ICustomerService;
import com.example.case_study.service.customer.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("customer")
public class CustomerController {

    @Autowired
    ICustomerService customerService;

    @Autowired
    ICustomerTypeService customerTypeService;

    @GetMapping("")
    public String showList(@RequestParam(defaultValue = "")String search , Model model, @PageableDefault(page = 0,size = 3)Pageable pageable){
        Page<Customer> customerList = customerService.searchName(search,pageable);
        model.addAttribute("customerList",customerList);
        return "customer/list";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id,Model model){
        model.addAttribute("customer",customerService.findById(id));
        model.addAttribute("customerTypes",customerTypeService.findAll());
        return "/customer/edit";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("customer") Customer customer,RedirectAttributes redirectAttributes){
        customerService.save(customer);
        redirectAttributes.addFlashAttribute("mess","Edit SussesFully");
        return "redirect:/customer";
    }

    @GetMapping("/show-list-create")
    public String showFormCreate(Model model){
        model.addAttribute("customer",new Customer());
        model.addAttribute("customerTypes",customerTypeService.findAll());
        return "/customer/create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("customer")Customer customer,RedirectAttributes redirectAttributes){
        customerService.save(customer);
        redirectAttributes.addFlashAttribute("mess","Create new customer SussesFully");
        return "redirect:/customer";
    }

    @PostMapping("/delete")
    public String delete(@ModelAttribute Long id,RedirectAttributes redirectAttributes){
        customerService.remove(id);
        redirectAttributes.addFlashAttribute("mess","Delete is finned");
        return "redirect:/customer";
    }
}
