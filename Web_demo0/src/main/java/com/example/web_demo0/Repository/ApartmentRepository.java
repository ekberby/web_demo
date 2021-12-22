package com.example.web_demo0.Repository;

import com.example.web_demo0.Model.Entity.Apartment;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ApartmentRepository extends CrudRepository<Apartment, Integer> {
    List<Apartment> findAll();

    List<Apartment> findApartmentsByOwner_Username(String id);
}
