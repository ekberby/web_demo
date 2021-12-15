package com.example.web_demo0.Service;

import com.example.web_demo0.Model.Entity.Apartment;

import java.util.List;

public interface ApartmentService {

    List<Apartment> getAll();

    void create(Apartment apartment);

    Apartment getById(Integer id);
}
