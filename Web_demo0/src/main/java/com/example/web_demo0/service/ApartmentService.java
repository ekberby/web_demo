package com.example.web_demo0.service;

import com.example.web_demo0.model.entity.Apartment;
import com.example.web_demo0.model.dto.ApartmentDto;

import java.util.List;

public interface ApartmentService {

    List<ApartmentDto> getAll();

    List<ApartmentDto> getAllByOwner_id(String id);

    void create(Apartment apartment);
}
