package com.example.web_demo0.Model.dto;


import com.example.web_demo0.Model.Enum.Role;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private String username;
    private String email;
}

