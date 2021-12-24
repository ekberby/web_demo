package com.example.web_demo0.service.impl;

import com.example.web_demo0.model.entity.Apartment;
import com.example.web_demo0.model.dto.ApartmentDto;
import com.example.web_demo0.repository.ApartmentRepository;
import com.example.web_demo0.service.ApartmentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class ApartmentServiceImpl implements ApartmentService {

    private final ApartmentRepository apartmentRepository;

    @Override
    public List<ApartmentDto> getAll() {
        return apartmentRepository.findAll().stream().map(this::mapToApartmentDto).collect(Collectors.toList());
    }

    @Override
    public List<ApartmentDto> getAllByOwnerId(String id) {
        return apartmentRepository.findApartmentsByOwner_Username(id).stream().map(this::mapToApartmentDto).collect(Collectors.toList());
    }

    @Override
    public void create(Apartment apartment) {
        apartmentRepository.save(apartment);
    }

    private ApartmentDto mapToApartmentDto(Apartment apartment){
        return ApartmentDto.builder().address(apartment.getAddress()).description(apartment.getDescription())
                .ownerUsername(apartment.getOwner().getUsername()).pricePerMonth(apartment.getPricePerMonth()).build();
    }

}
