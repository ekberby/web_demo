package com.example.web_demo0.service

import com.example.web_demo0.model.entity.User
import com.example.web_demo0.model.enums.Role
import com.example.web_demo0.model.dto.UserDto
import com.example.web_demo0.repository.UserRepository
import com.example.web_demo0.service.Impl.UserServiceImpl
import spock.lang.Specification

class UserServiceTest extends Specification {
    private UserRepository userRepository = Mock()
    private UserService userService = new UserServiceImpl(userRepository)

    def "test create - success"() {
        given:
        def user = User.builder().username("a").first_name("a").last_name("a")
                .email("a").password("a").role(Role.LANDLORD).build()

        when:
        userService.create(user)

        then:
        1 * userRepository.save(user)
    }

    def "test getAll()"() {
        given:
        def userDtoList = List.of(UserDto.builder().email("a").username("a").build())
        def userList = List.of(User.builder().email("a").username("a").build())

        when:
        def result = userService.getAll()

        then:
        1 * userRepository.findAll() >> userList
        result == userDtoList
    }
}
