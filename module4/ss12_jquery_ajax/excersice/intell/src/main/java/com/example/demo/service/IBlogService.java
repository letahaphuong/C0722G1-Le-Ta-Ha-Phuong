package com.example.demo.service;

import com.example.demo.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface IBlogService extends IGeneralService<Blog>{
    Page<Blog> findByProducerBlogContaining(String name, Pageable pageable);

}
