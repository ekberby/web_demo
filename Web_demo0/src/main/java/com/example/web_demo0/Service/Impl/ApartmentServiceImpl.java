package com.example.web_demo0.Service.Impl;

import com.example.web_demo0.Model.Entity.Apartment;
import com.example.web_demo0.Repository.ApartmentRepository;
import com.example.web_demo0.Service.ApartmentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ApartmentServiceImpl implements ApartmentService {

    private final ApartmentRepository apartmentRepository;

    @Override
    public List<Apartment> getAll() {
        return apartmentRepository.findAll();
    }

    @Override
    public void create(Apartment apartment) {
        apartmentRepository.save(apartment);
    }

    @Override
    public Apartment getById(Integer id) {
        return apartmentRepository.findById(id).get();
    }
}
