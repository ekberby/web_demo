package com.example.web_demo0.Service.Impl;

import com.example.web_demo0.Model.Entity.User;
import com.example.web_demo0.Repository.UserRepository;
import com.example.web_demo0.Service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public void create(User user) {
        userRepository.save(user);
    }

    public User getById(String username) {
        return userRepository.findById(username).get();
    }
}
