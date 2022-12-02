package com.example.demo.repository;

import com.example.demo.dto.UserDto;
import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, Long> {
}
