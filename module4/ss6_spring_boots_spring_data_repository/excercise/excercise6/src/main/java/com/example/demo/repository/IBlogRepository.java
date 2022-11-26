package com.example.demo.repository;

import com.example.demo.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IBlogRepository extends JpaRepository<Blog,Long> {

    @Query(value="select * from blog b where b.name like concat('%',:name,'%') or b.producer_blog like CONCAT('%',:producerBlog,'%') order by b.date_create;",nativeQuery=true)
    List<Blog> searchNameContentAndProducerBlog(@Param("name") String name,@Param("producerBlog") String producerBlog);

    @Query(value="select b from Blog b", countQuery="select count(b) from Blog b")
    Page<Blog> findMembers(Pageable pageable);


}
