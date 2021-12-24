package com.example.web_demo0.service

import com.example.web_demo0.model.entity.User
import com.example.web_demo0.model.enums.Role
import com.example.web_demo0.model.dto.UserDto
import com.example.web_demo0.repository.UserRepository
import com.example.web_demo0.service.impl.UserServiceImpl
import spock.lang.Specification

class UserServiceTest extends Specification {
    private UserRepository userRepository = Mock()
    private UserService userService = new UserServiceImpl(userRepository)

    def "test create - success"() {
        def user = new User()

        when:
        userService.create(user)

        then:
        1 * userRepository.save(user)
    }

    def "test getAll()"() {
        def userDtoList = List.of(UserDto.builder().email("a").username("a").build())
        def userList = List.of(User.builder().email("a").username("a").build())

        when:
        def result = userService.getAll()

        then:
        1 * userRepository.findAll() >> userList
        result == userDtoList
    }

    def "test getById"(){
        def userDto = UserDto.builder().email("a").username("a").build()

        Optional<UserDto> optional = Optional.of(User.builder().username("a").password("a").firstName("a")
                .lastName("a").email("a").role(Role.LANDLORD).build())
        when:

        def result = userService.getById(optional.get().getUsername())

        then:
        1*userRepository.findById(optional.get().getUsername()) >> optional
        result == userDto
    }
}
