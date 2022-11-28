package com.example.rom_for_rent.repository;

import com.example.rom_for_rent.model.RoomForRent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import java.util.List;

public interface IRoomForRentRepository extends JpaRepository<RoomForRent,Long> {

    @Query(value="select * from room_for_rent r where r.customer_name like concat('%',:customerName,'%') or r.phone_number like CONCAT('%',:phoneNumber,'%');",nativeQuery=true)
    List<RoomForRent> searchIdAndNameAndPhone(@Param("customerName") String customerName, @Param("phoneNumber") String phoneNumber);
}
