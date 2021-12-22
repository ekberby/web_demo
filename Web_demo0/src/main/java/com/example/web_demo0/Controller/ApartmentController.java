package com.example.web_demo0.Controller;

import com.example.web_demo0.Model.Entity.Apartment;
import com.example.web_demo0.Model.Entity.Rent;
import com.example.web_demo0.Model.Enum.Role;
import com.example.web_demo0.Model.dto.ApartmentDto;
import com.example.web_demo0.Model.dto.RentDto;
import com.example.web_demo0.Service.ApartmentService;
import com.example.web_demo0.Service.RentService;
import com.example.web_demo0.Service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.security.Principal;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("apartments")
public class ApartmentController {
    private ApartmentService apartmentService;
    private RentService rentService;
    private UserService userService;

    @PostMapping("/")
    public void create(@RequestBody Apartment apartment){
        apartmentService.create(apartment);
    }

    @GetMapping("/owner")
    public List<ApartmentDto> getAllByOwnerId(Principal principal){
            return apartmentService.getAllByOwner_id(principal.getName());
    }

    @GetMapping("/")
    public List<ApartmentDto> getAll(){
        return apartmentService.getAll();
    }

    @GetMapping("/owner/rents")
    public List<RentDto> getAllRents(Principal principal){
            return rentService.getByOwner_Id(principal.getName());
    }
}
