package com.example.demo.controller;


import com.example.demo.dto.FilmListDto;
import com.example.demo.model.FilmList;
import com.example.demo.repository.IShowTimeTypeReponsitory;
import com.example.demo.service.IFilmListService;
import com.example.demo.service.IFilmNameService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("film")
public class FilmListController {

    @Autowired
    IFilmListService filmListService;

    @Autowired
    IFilmNameService filmNameService;

    @Autowired
    IShowTimeTypeReponsitory showTimeTypeReponsitory;

    @GetMapping("")
    public String showFilmList(Model model){
        model.addAttribute("filmList",filmListService.findAll());
        return "film/list";
    }

    @GetMapping("/create")
    public String showFormCreate(Model model){
        model.addAttribute("filmList",new FilmList());
        model.addAttribute("filmNameList",filmNameService.findAll());
        return "film/create";
    }

    @PostMapping("/save")
    public String save(@Validated @ModelAttribute("filmList")FilmListDto filmListDto, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        if (bindingResult.hasErrors()){
            return "film/create";
        }

        FilmList filmList=new FilmList();

        BeanUtils.copyProperties(filmListDto,filmList);
        filmListService.save(filmList);
        return 
    }
}
