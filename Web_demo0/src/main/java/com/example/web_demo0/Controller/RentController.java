package com.example.web_demo0.Controller;


import com.example.web_demo0.Model.Entity.Rent;
import com.example.web_demo0.Service.RentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("rents")
public class RentController {

    private RentService rentService;

    @PostMapping("/")
    public void create(@RequestBody Rent rent){
        rentService.create(rent);
    }

    @GetMapping("/")
    public List<Rent> getAll(){
        return rentService.getAll();
    }

}
