package com.example.web_demo0.Service;


import com.example.web_demo0.Model.Entity.Rent;

import java.util.List;

public interface RentService {

    List<Rent> getAll();

    void create(Rent rent);

    Rent getById(Integer id);
}
