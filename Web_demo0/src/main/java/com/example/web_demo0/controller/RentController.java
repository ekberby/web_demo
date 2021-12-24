package com.example.web_demo0.controller;

import com.example.web_demo0.model.entity.Rent;
import com.example.web_demo0.model.dto.RentDto;
import com.example.web_demo0.service.RentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("rents")
public class RentController {

    private final RentService rentService;

    @PostMapping("")
    public void create(@RequestBody Rent rent) {
        rentService.create(rent);
    }

    @GetMapping("")
    public List<RentDto> getAll() {
        return rentService.getAll();
    }

    @GetMapping("/renter")
    public List<RentDto> getAllByRenterId(Principal principal) {
        return rentService.getByRenterId(principal.getName());
    }
}
