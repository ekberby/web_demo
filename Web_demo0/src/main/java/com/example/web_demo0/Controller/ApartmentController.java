package com.example.web_demo0.Controller;

import com.example.web_demo0.Model.Entity.Apartment;
import com.example.web_demo0.Service.ApartmentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("apartments")
public class ApartmentController {
    private ApartmentService apartmentService;

    @PostMapping("/")
    public void create(@RequestBody Apartment apartment){
        apartmentService.create(apartment);
    }

    @GetMapping("/")
    public List<Apartment> getAll(){
        return apartmentService.getAll();
    }

    @GetMapping("/{id}")
    public List<Apartment> getById(){
        return apartmentService.getAll();
    }
}
