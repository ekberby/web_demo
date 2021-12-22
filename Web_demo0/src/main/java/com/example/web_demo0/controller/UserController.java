package com.example.web_demo0.controller;

import com.example.web_demo0.model.entity.User;
import com.example.web_demo0.model.dto.UserDto;
import com.example.web_demo0.service.Impl.UserServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")
@AllArgsConstructor
public class UserController {
    private final UserServiceImpl userService;

    @PostMapping("/")
    public void save(@RequestBody User user) {
        userService.create(user);
    }

    @GetMapping("/")
    public List<UserDto> get() {
        return userService.getAll();
    }
}
