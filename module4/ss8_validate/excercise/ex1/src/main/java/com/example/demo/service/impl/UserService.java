package com.example.demo.service.impl;

import com.example.demo.model.User;
import com.example.demo.repository.IUserRepository;
import com.example.demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService {

    @Autowired
    IUserRepository repository;

    @Override
    public List<User> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<User> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public void save(User user) {
        repository.save(user);
    }

    @Override
    public void remove(Long id) {
        repository.deleteById(id);
    }
}
