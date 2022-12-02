package com.example.demo.controller;

import com.example.demo.dto.SongDto;
import com.example.demo.model.Song;
import com.example.demo.service.ISongService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

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
        model.addAttribute("songDto", new SongDto());
        return "song/create";
    }

    @PostMapping("/save")
    public String save(@Validated @ModelAttribute("songDto") SongDto songDto, BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        new SongDto().validate(songDto, bindingResult);

        if (bindingResult.hasErrors()) {
            return "song/create";
        }

        Song song = new Song();

        BeanUtils.copyProperties(songDto, song);

        songService.save(song);
        redirectAttributes.addFlashAttribute("mess", "Thêm mới thành công");
        return "redirect:/song/show-list-create";
    }

    @GetMapping("/edit/{id}")
    public String showFormEdit(@PathVariable("id") Long id, Model model) {
        Optional<Song> song = songService.findById(id);

        if (song.isPresent()) {
            model.addAttribute("songDto", song.get());
            return "song/edit";
        }
        return "song/create";
    }

    @PostMapping("/update")
    public String update(@Validated @ModelAttribute("songDto") SongDto songDto, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        new SongDto().validate(songDto, bindingResult);
        if (bindingResult.hasErrors()) {
            return "song/edit";
        }

        Song song =new Song();

        BeanUtils.copyProperties(songDto,song);

        songService.save(song);
        redirectAttributes.addFlashAttribute("mess", "Sửa thành công");
        return "redirect:/song";
    }
}
