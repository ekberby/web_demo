package com.example.web_demo0.service.impl;

import com.example.web_demo0.model.entity.Rent;
import com.example.web_demo0.model.dto.RentDto;
import com.example.web_demo0.repository.RentRepository;
import com.example.web_demo0.service.RentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class RentServiceImpl implements RentService {
    private final RentRepository rentRepository;
    @Override
    public List<RentDto> getAll() {
        return rentRepository.findAll().stream().map(this::mapToRentDto).collect(Collectors.toList());
    }

    @Override
    public void create(Rent rent) {
        rentRepository.save(rent);
    }

    @Override
    public List<RentDto> getByOwnerId(String id) {
        return rentRepository.findAllByOwner_Username(id).stream().map(this::mapToRentDto).collect(Collectors.toList());
    }

    @Override
    public List<RentDto> getByRenterId(String id) {
        return rentRepository.findAllByRenter_Username(id).stream().map(this::mapToRentDto).collect(Collectors.toList());
    }

    private RentDto mapToRentDto(Rent rent){
        return RentDto.builder().ownerUsername(rent.getOwner().getUsername()).renterUsername(rent.getRenter().getUsername())
                .endMonth(rent.getEndMonth()).endYear(rent.getEndYear()).startMonth(rent.getStartMonth()).startYear(rent.getStartYear())
                .build();
    }

}
