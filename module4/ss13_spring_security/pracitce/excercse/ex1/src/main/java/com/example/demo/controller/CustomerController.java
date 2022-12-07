package com.example.demo.controller;


import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Customer;
import com.example.demo.model.Province;
import com.example.demo.service.CustomerService;
import com.example.demo.service.ProvinceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("customer")
public class CustomerController {

    private static final Logger LOG = LoggerFactory.getLogger(com.example.demo.controller.CustomerController.class);

    @Autowired
    private CustomerService customerService;

    @Autowired
    private ProvinceService provinceService;

    @ModelAttribute("provinces")
    public Iterable<Province> provinces() {
        return provinceService.findAll();
    }

    @GetMapping("")
    public String listCustomers(Model theModel) {
        List<Customer> theCustomers = customerService.getCustomers();
        theModel.addAttribute("customers", theCustomers);
        return "/customer/list-customer";
    }

    @GetMapping("/showForm")
    public String showFormForAdd(Model theModel) {
        LOG.debug("inside show customer-form handler method");
        Customer theCustomer = new Customer();
        theModel.addAttribute("customer", theCustomer);
        return "customer/create";
    }

    @PostMapping("/saveCustomer")
    public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {
        customerService.saveCustomer(theCustomer);
        return "redirect:/customer/";
    }

    @GetMapping("/update")
    public String showFormForUpdate(@RequestParam("id") Long theId,
                                    Model theModel) throws ResourceNotFoundException {
        Customer theCustomer = customerService.getCustomer(theId);
        theModel.addAttribute("customer", theCustomer);
        return "customer/edit";
    }

    @PostMapping("/update")
    public String updateCustomer(@ModelAttribute("customer") Customer theCustomer) {
        customerService.saveCustomer(theCustomer);
        return "redirect:/customer/";
    }

    @GetMapping("/delete")
    public String deleteCustomer(@RequestParam("id") Long theId) throws ResourceNotFoundException {
        customerService.deleteCustomer(theId);
        return "redirect:/customer/";
    }

    @GetMapping("/getCustomerByName")
    public String listCustomersByName(Model theModel, @RequestParam("name") String name) {
        Iterable<Customer> theCustomers = customerService.findCustomersByFirstName(name);
        theModel.addAttribute("customers", theCustomers);
        return "/customer/list-customer";
    }
}