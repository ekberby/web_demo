package com.example.web_demo0.controller;

import com.example.web_demo0.model.entity.Apartment;
import com.example.web_demo0.model.dto.ApartmentDto;
import com.example.web_demo0.model.dto.RentDto;
import com.example.web_demo0.service.ApartmentService;
import com.example.web_demo0.service.RentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("apartments")
public class ApartmentController {
    private final ApartmentService apartmentService;
    private final RentService rentService;

    @PostMapping("")
    public void create(@RequestBody Apartment apartment) {
        apartmentService.create(apartment);
    }

    @GetMapping("/owner")
    public List<ApartmentDto> getAllByOwnerId(Principal principal) {
        return apartmentService.getAllByOwnerId(principal.getName());
    }

    @GetMapping("")
    public List<ApartmentDto> getAll() {
        return apartmentService.getAll();
    }

    @GetMapping("/owner/rents")
    public List<RentDto> getAllRents(Principal principal) {
        return rentService.getByOwnerId(principal.getName());
    }
}
