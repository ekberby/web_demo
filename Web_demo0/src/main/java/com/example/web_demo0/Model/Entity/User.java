package com.example.web_demo0.Model.Entity;

import com.example.web_demo0.Model.Enum.Role;
import lombok.*;

import javax.persistence.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="users")
public class User {
    private String first_name;
    private String last_name;
    @Id
    private String username;
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role;
}
