package com.example.demo.dto;

import com.example.demo.model.Category;
import net.bytebuddy.implementation.bind.annotation.Empty;

import javax.validation.constraints.NotEmpty;

public class BlogDto {

    private Long id;

    @NotEmpty(message = "{NotEmpty}")
    private String name;

    @NotEmpty(message = "{NotEmpty}")
    private String contentBlog;

    @NotEmpty(message = "{NotEmpty}")
    private String producerBlog;

    @NotEmpty(message = "{NotEmpty}")
    private String dateCreate;

//    @NotEmpty(message = "{NotEmpty}")
    private Category category;

    public BlogDto() {
    }

    public BlogDto(Long id, String name, String contentBlog, String producerBlog, String dateCreate, Category category) {
        this.id = id;
        this.name = name;
        this.contentBlog = contentBlog;
        this.producerBlog = producerBlog;
        this.dateCreate = dateCreate;
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContentBlog() {
        return contentBlog;
    }

    public void setContentBlog(String contentBlog) {
        this.contentBlog = contentBlog;
    }

    public String getProducerBlog() {
        return producerBlog;
    }

    public void setProducerBlog(String producerBlog) {
        this.producerBlog = producerBlog;
    }

    public String getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(String dateCreate) {
        this.dateCreate = dateCreate;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
