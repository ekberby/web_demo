package com.example.web_demo0.service

import com.example.web_demo0.model.dto.RentDto
import com.example.web_demo0.model.entity.Rent
import com.example.web_demo0.model.entity.User
import com.example.web_demo0.model.enums.Role
import com.example.web_demo0.repository.RentRepository
import com.example.web_demo0.service.impl.RentServiceImpl
import spock.lang.Specification

class RentServiceTest extends Specification{
    private final RentRepository rentRepository = Mock();
    private final RentService rentService = new RentServiceImpl(rentRepository);

    def "test getAll"(){
        def rentDtoList = List.of(RentDto.builder().ownerUsername("a").endMonth(1).endYear(1)
                .startMonth(1).startYear(1).renterUsername("a").build())

        def rentList = List.of(Rent.builder().startYear(1).startMonth(1).endYear(1)
                .endMonth(1).rentId(1).renter(User.builder().username("a").password("a")
                .firstName("a").lastName("a").email("a").role(Role.TENANT).build()).owner(User.builder()
                .username("a").password("a").firstName("a").lastName("a").email("a")
                .role(Role.LANDLORD).build()).build())
        when:
        def result = rentService.getAll()
        then:
        1*rentRepository.findAll() >> rentList
        result == rentDtoList
    }

    def "test create - success"(){
        def rent = new Rent()
        when:
        rentService.create(rent)
        then:
        1*rentRepository.save(rent)
    }

    def "test getByOwnerId"(){
        def rentDtoList = List.of(RentDto.builder().ownerUsername("a").endMonth(1).endYear(1)
                .startMonth(1).startYear(1).renterUsername("a").build())

        def rentList = List.of(Rent.builder().startYear(1).startMonth(1).endYear(1)
                .endMonth(1).rentId(1).renter(User.builder().username("a").password("a")
                .firstName("a").lastName("a").email("a").role(Role.TENANT).build()).owner(User.builder()
                .username("a").password("a").firstName("a").lastName("a").email("a")
                .role(Role.LANDLORD).build()).build())

        def id = "a"

        when:
        def result = rentService.getByOwnerId(id)
        then:
        1*rentRepository.findAllByOwner_Username(id) >> rentList
        result == rentDtoList
    }

    def "test getByRenterId"(){
        def rentDtoList = List.of(RentDto.builder().ownerUsername("a").endMonth(1).endYear(1)
                .startMonth(1).startYear(1).renterUsername("a").build())

        def rentList = List.of(Rent.builder().startYear(1).startMonth(1).endYear(1)
                .endMonth(1).rentId(1).renter(User.builder().username("a").password("a")
                .firstName("a").lastName("a").email("a").role(Role.TENANT).build()).owner(User.builder()
                .username("a").password("a").firstName("a").lastName("a").email("a")
                .role(Role.LANDLORD).build()).build())

        def id = "a"

        when:
        def result = rentService.getByRenterId(id)
        then:
        1*rentRepository.findAllByRenter_Username(id) >> rentList
        result == rentDtoList
    }
}
