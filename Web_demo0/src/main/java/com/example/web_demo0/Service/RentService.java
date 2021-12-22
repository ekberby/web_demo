package com.example.web_demo0.Service;


import com.example.web_demo0.Model.Entity.Rent;
import com.example.web_demo0.Model.dto.RentDto;

import java.security.Principal;
import java.util.List;

public interface RentService {

    List<RentDto> getAll();

    void create(Rent rent);

    List<RentDto> getByOwner_Id(String id);

    List<RentDto> getByRenter_Id(String id);

}
