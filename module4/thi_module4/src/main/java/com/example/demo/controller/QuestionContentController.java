package com.example.demo.controller;


import com.example.demo.model.QuestionContent;
import com.example.demo.service.IQuestionContentService;
import com.example.demo.service.IQuestionTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("question")
public class QuestionContentController {

    @Autowired
    IQuestionContentService questionContentService;

    @Autowired
    IQuestionTypeService questionTypeService;

    @GetMapping("")
    public String showAll(@RequestParam(defaultValue = "") String title
            , @RequestParam(defaultValue = "") String questionType, Model model, @PageableDefault(page = 0, size = 3) Pageable pageable) {
        Page<QuestionContent> questionContents = questionContentService.showAll(title, questionType, pageable);
        model.addAttribute("questionContentList", questionContents);
        model.addAttribute("questionTypeList", questionTypeService.findAll());
        model.addAttribute("titleSearch", title);
        model.addAttribute("questionTypeSearch", questionType);
        return "question/list";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam Long id, RedirectAttributes redirectAttributes) {
        questionContentService.removeFlag(id);
        redirectAttributes.addFlashAttribute("mess", "Xoá thành công");
        return "redirect:/question";
    }

    @GetMapping("/show-list-create")
    public String showFormCreate(Model model) {
        model.addAttribute("questionContent", new QuestionContent());
        model.addAttribute("questionTypeList", questionTypeService.findAll());
        return "question/create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("questionContent") QuestionContent questionContent, RedirectAttributes redirectAttributes, Model model) {
        questionContentService.save(questionContent);
        model.addAttribute("questionTypeList", questionTypeService.findAll());
        redirectAttributes.addFlashAttribute("mess", "Thêm mới thành công");
        return "redirect:/question/show-list-create";
    }

    @GetMapping("/detail/{id}")
    public String showDetail(@PathVariable("id") Long id, Model model) {
        model.addAttribute("questionContent", questionContentService.findById(id).get());
        model.addAttribute("questionTypeList", questionTypeService.findAll());
        return "question/detail";
    }

    @GetMapping("/edit/{id}")
    public String showFormEdit(@PathVariable("id") Long id,Model model){
        model.addAttribute("questionContent",questionContentService.findById(id).get());
        model.addAttribute("questionTypeList", questionTypeService.findAll());
        return "question/edit";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("questionContent") QuestionContent questionContent, RedirectAttributes redirectAttributes,
                        Model model){
        questionContentService.save(questionContent);
        model.addAttribute("questionTypeList", questionTypeService.findAll());
        redirectAttributes.addFlashAttribute("mess","Cập nhật thành công");
        return "redirect:/question";
    }
}
