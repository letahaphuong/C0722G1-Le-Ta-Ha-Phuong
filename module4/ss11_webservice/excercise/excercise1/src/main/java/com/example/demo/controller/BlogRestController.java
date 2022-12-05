package com.example.demo.controller;

import com.example.demo.model.Blog;
import com.example.demo.model.Category;
import com.example.demo.service.IBlogService;
import com.example.demo.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/blogs")
public class BlogRestController {

    @Autowired
    IBlogService blogService;

    @Autowired
    ICategoryService categoryService;

    @GetMapping("")
    public ResponseEntity<Page<Blog>> showListBlog(@PageableDefault(page = 0, size = 3)
                                                           Pageable pageable) {
        Page<Blog> blogs = blogService.findAll(pageable);
        if (blogs.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogs, HttpStatus.OK);
    }

    @GetMapping("viewByCategory/{category}/{pageable}")
    public ResponseEntity<Page<Blog>> findByCategory(@PathVariable("category") Category category,@PageableDefault(page = 0, size = 3)
                                                                 Pageable pageable){
        Page<Blog> blogs=blogService.findByCategory(category,pageable);
        if (blogs.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogs,HttpStatus.OK);
    }

    @GetMapping("details/{id}")
    private ResponseEntity showDetail(@PathVariable("id") Long id){
        Blog blogOptional=blogService.findById(id).get();
        if (blogOptional==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blogOptional,HttpStatus.OK);
    }
}
