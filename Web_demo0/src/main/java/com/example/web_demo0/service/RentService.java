package com.example.web_demo0.service;

import com.example.web_demo0.model.entity.Rent;
import com.example.web_demo0.model.dto.RentDto;

import java.util.List;

public interface RentService {

    List<RentDto> getAll();

    void create(Rent rent);

    List<RentDto> getByOwner_Id(String id);

    List<RentDto> getByRenter_Id(String id);

}
