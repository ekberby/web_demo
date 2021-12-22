package com.example.web_demo0.Service.Impl;

import com.example.web_demo0.Model.Entity.Apartment;
import com.example.web_demo0.Model.Entity.Rent;
import com.example.web_demo0.Model.Entity.User;
import com.example.web_demo0.Model.Enum.Role;
import com.example.web_demo0.Model.dto.ApartmentDto;
import com.example.web_demo0.Repository.ApartmentRepository;
import com.example.web_demo0.Repository.UserRepository;
import com.example.web_demo0.Service.ApartmentService;
import com.example.web_demo0.Service.RentService;
import com.example.web_demo0.Service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class ApartmentServiceImpl implements ApartmentService {

    private final ApartmentRepository apartmentRepository;

    @Override
    public List<ApartmentDto> getAll() {
        return apartmentRepository.findAll().stream().map(apartment -> mapToApartmentDto(apartment)).collect(Collectors.toList());
    }

    @Override
    public List<ApartmentDto> getAllByOwner_id(String id) {
        return apartmentRepository.findApartmentsByOwner_Username(id).stream().map(apartment -> mapToApartmentDto(apartment)).collect(Collectors.toList());
    }

    @Override
    public void create(Apartment apartment) {
        apartmentRepository.save(apartment);
    }

    private ApartmentDto mapToApartmentDto(Apartment apartment){
        return ApartmentDto.builder().address(apartment.getAddress()).description(apartment.getDescription())
                .owner_username(apartment.getOwner().getUsername())
                .price_per_month(apartment.getPrice_per_month()).build();
    }

}
