package com.example.demo.controller;

import com.example.demo.model.Song;
import com.example.demo.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("song")
public class SongController {

    @Autowired
    private ISongService songService;

    @GetMapping("")
    public String showList(Model model) {
        model.addAttribute("songList", songService.findAll());
        return "song/list";
    }

    @GetMapping("/show-list-create")
    public String showFormCreate(Model model) {
        model.addAttribute("song", new Song());
        return "song/create";
    }

    @PostMapping("/save")
    public String save(@Validated @ModelAttribute("song") Song song, BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        new Song().validate(song,bindingResult);

        if (bindingResult.hasErrors()) {
            return "song/create";
        }
        songService.save(song);
        redirectAttributes.addFlashAttribute("mess", "Thêm mới thành công");
        return "redirect:/song/show-list-create";
    }

    @GetMapping("/edit/{id}")
    public String showFormEdit(@PathVariable("id") Long id,Model model){
        model.addAttribute("song",songService.findById(id));
        return "song/edit";
    }

    @PostMapping("/update")
    public String update(@Validated @ModelAttribute("song") Song song,BindingResult bindingResult,RedirectAttributes redirectAttributes){
        new Song().validate(song,bindingResult);
        if (bindingResult.hasErrors()){
            return "song/edit";
        }

        songService.save(song);
        redirectAttributes.addFlashAttribute("mess","Thêm mới thành công");
        return "redirect:/song";
    }
}
