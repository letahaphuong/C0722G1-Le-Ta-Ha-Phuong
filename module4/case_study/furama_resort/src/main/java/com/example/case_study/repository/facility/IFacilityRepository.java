package com.example.case_study.repository.facility;

import com.example.case_study.model.customer.Customer;
import com.example.case_study.model.facility.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IFacilityRepository extends JpaRepository<Facility,Long> {

    @Query(value = "select * from facility f where f.name like concat('%',:name,'%') order by f.name",
          countQuery ="select * from facility f where f.name like concat('%',:name,'%') order by f.name"
            ,nativeQuery = true)
    Page<Facility> searchName(@Param("name") String name, Pageable pageable);
}
