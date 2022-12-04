package com.example.case_study.repository.customer;

import com.example.case_study.dto.customer.CustomerView;
import com.example.case_study.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ICustomerRepository extends JpaRepository<Customer,Long> {
    @Query(value = "select * from customer c where c.name like concat('%',:name,'%') order by c.name",
            countQuery ="select * from customer c where c.name like concat('%',:name,'%') order by c.name"
            ,nativeQuery = true)
    Page<Customer> searchName(@Param("name") String name, Pageable pageable);

//    @Query(value="select c.id as id, c.customer_type_id as customerType, c.name as name,c.date_of_birth as dateOfBirth,c.phone_number as phoneNumber,c.gender,c.address from customer as c;",nativeQuery = true)
    @Query(value="select c.id, c.customer_type_id as customerTypeId, c.name ,c.date_of_birth as dateOfBirth,c.phone_number as phoneNumber,c.gender from customer as c"
            ,countQuery="select c.id, c.customer_type_id , c.name ,c.date_of_birth,c.phone_number,c.gender,c.address from customer as c"
            ,nativeQuery = true)
    Page<CustomerView> searchView(Pageable pageable);
}
