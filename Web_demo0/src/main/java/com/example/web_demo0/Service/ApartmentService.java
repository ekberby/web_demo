package com.example.web_demo0.Service;

import com.example.web_demo0.Model.Entity.Apartment;
import com.example.web_demo0.Model.Entity.Rent;
import com.example.web_demo0.Model.dto.ApartmentDto;

import java.security.Principal;
import java.util.List;

public interface ApartmentService {

    List<ApartmentDto> getAll();

    List<ApartmentDto> getAllByOwner_id(String id);

    void create(Apartment apartment);
}
