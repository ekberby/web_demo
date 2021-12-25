package com.example.web_demo0.service

import com.example.web_demo0.model.UserPrincipal
import com.example.web_demo0.model.entity.User
import com.example.web_demo0.model.enums.Role
import com.example.web_demo0.repository.UserRepository
import com.example.web_demo0.service.impl.UserDetailServiceImpl
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import spock.lang.Specification

class UserDetailServiceTest extends Specification {

    private final UserRepository userRepository = Mock()
    private final UserDetailsService userDetailsService = new UserDetailServiceImpl(userRepository)

    def "test loadUserByUsername"() {
        def id = "a"
        UserPrincipal userPrincipal = new UserPrincipal(User.builder().username("a").password("a")
                .role(Role.LANDLORD).build())
        def optional = Optional.of(User.builder().username("a").password("a").role(Role.LANDLORD).build())

        when:
        def result = userDetailsService.loadUserByUsername(id)

        then:
        1 * userRepository.findById(id) >> optional
        result.getUsername() == userPrincipal.getUsername()
        result.getPassword() == userPrincipal.getPassword()
        result.getAuthorities() == userPrincipal.getAuthorities()
    }
}
