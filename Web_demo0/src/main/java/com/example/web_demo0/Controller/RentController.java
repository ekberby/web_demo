package com.example.web_demo0.Controller;


import com.example.web_demo0.Model.Entity.Rent;
import com.example.web_demo0.Model.Enum.Role;
import com.example.web_demo0.Model.dto.RentDto;
import com.example.web_demo0.Service.Impl.UserServiceImpl;
import com.example.web_demo0.Service.RentService;
import com.example.web_demo0.Service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("rents")
public class RentController {

    private RentService rentService;
    private UserService userService;

    @PostMapping("/")
    public void create(@RequestBody Rent rent){
        rentService.create(rent);
    }

    @GetMapping("/")
    public List<RentDto> getAll(){
        return rentService.getAll();
    }

    @GetMapping("/renter")
    public List<RentDto> getAllByRenter_id(Principal principal){
            return rentService.getByRenter_Id(principal.getName());
    }
}
