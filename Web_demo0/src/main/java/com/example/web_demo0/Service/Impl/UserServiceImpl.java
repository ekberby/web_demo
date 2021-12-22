package com.example.web_demo0.Service.Impl;

import com.example.web_demo0.Model.Entity.User;
import com.example.web_demo0.Model.dto.UserDto;
import com.example.web_demo0.Repository.UserRepository;
import com.example.web_demo0.Service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public List<UserDto> getAll() {
        return userRepository.findAll().stream().map(user -> mapToUserDto(user)).collect(Collectors.toList());
    }

    public void create(User user) {
        userRepository.save(user);
    }

    public UserDto getById(String username) {
        return userRepository.findById(username).map(user -> mapToUserDto(user)).get();
    }

    private UserDto mapToUserDto(User user){
        return UserDto.builder().username(user.getUsername()).email(user.getEmail()).build();
    }
}
