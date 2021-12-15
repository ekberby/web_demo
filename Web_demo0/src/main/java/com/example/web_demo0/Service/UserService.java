package com.example.web_demo0.Service;

import com.example.web_demo0.Model.Entity.User;

import java.util.List;

public interface UserService {

    List<User> getAll();

    void create(User user);

    User getById(String username);
}
