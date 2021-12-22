package com.example.web_demo0.Service

import com.example.web_demo0.Model.Entity.User
import com.example.web_demo0.Model.Enum.Role
import com.example.web_demo0.Model.dto.UserDto
import com.example.web_demo0.Repository.UserRepository
import com.example.web_demo0.Service.Impl.UserServiceImpl
import spock.lang.Specification

class UserServiceTest extends Specification {
    private UserRepository userRepository = Mock();
    private UserService userService = new UserServiceImpl(userRepository);

    def "test create(User user)"(){

        def user = User.builder().username("a").first_name("a")
                .last_name("a").email("a").password("a").role(Role.LANDLORD).build()

        when:

        userService.create(user)
        then:


        1*userRepository.save(user)

    }

    def "test getAll()"(){
        List<UserDto> userDtoList = new ArrayList<>();

        UserDto userDto = UserDto.builder().email("a").username("a").build()

        userDtoList.add(userDto)
        when:
        def result = userService.getAll()
        then:

        1*userRepository.findAll()
        result == userDtoList
    }
}
