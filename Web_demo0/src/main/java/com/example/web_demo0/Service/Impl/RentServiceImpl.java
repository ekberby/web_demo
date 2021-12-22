package com.example.web_demo0.Service.Impl;

import com.example.web_demo0.Model.Entity.Rent;
import com.example.web_demo0.Model.dto.RentDto;
import com.example.web_demo0.Repository.RentRepository;
import com.example.web_demo0.Service.RentService;
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
        return rentRepository.findAll().stream().map(rent -> mapToRentDto(rent)).collect(Collectors.toList());
    }

    @Override
    public void create(Rent rent) {
        rentRepository.save(rent);
    }

    @Override
    public List<RentDto> getByOwner_Id(String id) {
        return rentRepository.findAllByOwner_Username(id).stream()
                .map(rent -> mapToRentDto(rent)).collect(Collectors.toList());
    }

    @Override
    public List<RentDto> getByRenter_Id(String id) {
        return rentRepository.findAllByRenter_Username(id).stream()
                .map(rent -> mapToRentDto(rent)).collect(Collectors.toList());
    }

    private RentDto mapToRentDto(Rent rent){
        return RentDto.builder().owner_username(rent.getOwner().getUsername())
                .renter_username(rent.getRenter().getUsername()).end_month(rent.getEnd_month())
                .end_year(rent.getEnd_year()).start_month(rent.getStart_month())
                .start_year(rent.getStart_year()).build();
    }

}
