package com.example.demo.repository;

import com.example.demo.model.QuestionContent;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface IQuestionContentRepository extends JpaRepository<QuestionContent,Long> {

//    @Query(value="select q.id,q.title, q.content,q.question_type_id,q.answer,q.date_create,q.status,q.flag_delete from question_content as q where flag_delete=false",
//            countQuery="select q.id,q.title, q.content,q.question_type_id,q.answer,q.date_create,q.status,q.flag_delete from question_content as q where flag_delete=false"
//            ,nativeQuery=true)
//    Page<QuestionContent> showAll(Pageable pageable);


    @Query(value="select q.id,q.title, q.content,q.question_type_id,q.answer,q.date_create,q.status,q.flag_delete from question_content as q where flag_delete=false and (q.title like concat('%',:title,'%') and q.question_type_id like concat('%',:id,'%'))",
            countQuery="select q.id,q.title, q.content,q.question_type_id,q.answer,q.date_create,q.status,q.flag_delete from question_content as q where flag_delete=false and (q.title like concat('%',:title,'%') and q.question_type_id like concat('%',:id,'%'))"
            ,nativeQuery=true)
    Page<QuestionContent> showAll(@Param("title") String title,@Param("id") String questionType ,Pageable pageable);


    @Transactional
    @Modifying
    @Query(value="update question_content as q set q.flag_delete=true where q.id= :id ",nativeQuery=true)
    void removeFlag(@Param("id") Long id);
}
