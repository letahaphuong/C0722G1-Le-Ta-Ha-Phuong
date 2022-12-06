package com.example.demo.repository;

import com.example.demo.model.Blog;
import com.example.demo.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ICategoryRepository extends JpaRepository<Category,Long> {


//    @Query(value="select c.*, b.* from category as c join blog b on c.category_id = b.category_id where c.name like :name "
//            , countQuery="select c.*, b.* from category as c join blog b on c.category_id = b.category_id where c.name like :name "
//            ,nativeQuery=true)
//    List<Category> searchNameCategory(@Param("name") String name);

}
