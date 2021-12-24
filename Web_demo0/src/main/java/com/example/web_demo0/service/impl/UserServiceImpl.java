package com.example.web_demo0.service.impl;

import com.example.web_demo0.model.entity.User;
import com.example.web_demo0.model.dto.UserDto;
import com.example.web_demo0.repository.UserRepository;
import com.example.web_demo0.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public List<UserDto> getAll() {
        return userRepository.findAll().stream().map(this::mapToUserDto).collect(Collectors.toList());
    }

    public void create(User user) {
        userRepository.save(user);
    }

    public UserDto getById(String username){
        return userRepository.findById(username).map(this::mapToUserDto).get();
    }

    private UserDto mapToUserDto(User user){
        return UserDto.builder().username(user.getUsername()).email(user.getEmail()).build();
    }
}
