package com.example.web_demo0.repository;

import com.example.web_demo0.model.entity.Apartment;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ApartmentRepository extends CrudRepository<Apartment, Integer> {
    List<Apartment> findAll();

    List<Apartment> findApartmentsByOwner_Username(String id);
}
