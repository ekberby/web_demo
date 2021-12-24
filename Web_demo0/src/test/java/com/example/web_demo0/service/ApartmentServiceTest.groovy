package com.example.web_demo0.service

import com.example.web_demo0.model.dto.ApartmentDto
import com.example.web_demo0.model.entity.Apartment
import com.example.web_demo0.model.enums.Role
import com.example.web_demo0.repository.ApartmentRepository
import com.example.web_demo0.service.impl.ApartmentServiceImpl
import spock.lang.Specification
import com.example.web_demo0.model.entity.User

class ApartmentServiceTest extends Specification{
    private final ApartmentRepository apartmentRepository = Mock();
    private final ApartmentService apartmentService= new ApartmentServiceImpl(apartmentRepository);

    def "test create - success"(){
        def apartment = new Apartment()
        when:
        apartmentService.create(apartment)
        then:
        1*apartmentRepository.save(apartment)
    }

    def "test getAll"(){
        def list1 = List.of(Apartment.builder().address("a").appId(1).description("a")
                .pricePerMonth(150).owner(User.builder().username("a").firstName("a")
                .lastName("a").email("a").password("a").role(Role.LANDLORD).build()).build())
        def list2 = List.of(ApartmentDto.builder().pricePerMonth(150).description("a")
                .address("a").ownerUsername("a").build())
        when:
        def result = apartmentService.getAll()
        then:
        1*apartmentRepository.findAll() >> list1
        result == list2
    }

    def "test getAllByOwnerId"(){
        def id = "a"
        def list1 = List.of(Apartment.builder().address("a").appId(1).description("a")
                .pricePerMonth(150).owner(User.builder().username("a").firstName("a")
                .lastName("a").email("a").password("a").role(Role.LANDLORD).build()).build())
        def list2 = List.of(ApartmentDto.builder().pricePerMonth(150).description("a")
                .address("a").ownerUsername("a").build())

        when:

        def result = apartmentService.getAllByOwnerId(id)

        then:
        1*apartmentRepository.findApartmentsByOwner_Username(id) >> list1
        result == list2
    }
}
