package com.example.demo.repository;

import com.example.demo.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface IBlogRepository extends JpaRepository<Blog, Long> {

    @Query(value = "select * from blog b where b.name like concat('%',:name,'%') or b.producer_blog like CONCAT('%',:producerBlog,'%')",
            countQuery ="select * from blog b where b.name like concat('%',:name,'%') or b.producer_blog like CONCAT('%',:producerBlog,'%')"
            ,nativeQuery = true)
    Page<Blog> searchNameProducerBlog(@Param("name") String name, @Param("producerBlog") String producerBlog, Pageable pageable);

}
