package com.example.web_demo0.Repository;

import com.example.web_demo0.Model.Entity.Rent;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RentRepository extends CrudRepository<Rent, Integer> {
    List<Rent> findAll();

    List<Rent> findAllByOwner_Username(String id);

    List<Rent> findAllByRenter_Username(String id);
}
