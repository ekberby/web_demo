package com.example.web_demo0.Service.Impl;

import com.example.web_demo0.Model.Entity.Rent;
import com.example.web_demo0.Repository.RentRepository;
import com.example.web_demo0.Service.RentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class RentServiceImpl implements RentService {

    private final RentRepository rentRepository;
    @Override
    public List<Rent> getAll() {
        return rentRepository.findAll();
    }

    @Override
    public void create(Rent rent) {
        rentRepository.save(rent);
    }

    @Override
    public Rent getById(Integer id) {
        return rentRepository.findById(id).get();
    }
}
