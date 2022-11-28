package com.example.demo.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    //id,tiêu đề,nội dung,tác giả,ngày viết blog
    private Long id;

    private String name;

    @Column(columnDefinition = "text")
    private String contentBlog;

    private String producerBlog;

    @Column(columnDefinition = "date")
    private String dateCreate;

    @ManyToOne
    @JoinColumn(name = "category_id",nullable = false,referencedColumnName = "category_id")
    private Category category;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Blog() {
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
}
