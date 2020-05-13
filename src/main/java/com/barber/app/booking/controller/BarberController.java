package com.barber.app.booking.controller;


import com.barber.app.booking.dto.BarberDto;
import com.barber.app.booking.dto.ClientDto;
import com.barber.app.booking.model.request.BarberDetailsRequestModel;
import com.barber.app.booking.model.request.UserDetailsRequestModel;
import com.barber.app.booking.model.response.BarberRest;
import com.barber.app.booking.model.response.UserRest;
import com.barber.app.booking.service.BarberService;
import com.barber.app.booking.service.ClientService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/barbers")
public class BarberController {

    @Autowired
    BarberService barberService;


    @GetMapping
    public String getUser()
    {
        return "get user was celled";
    }

    @PostMapping
    public BarberRest createBarber(@RequestBody BarberDetailsRequestModel barberDetails)
    {
        BarberRest returnValue = new BarberRest();

        BarberDto barberDto = new BarberDto();
        BeanUtils.copyProperties(barberDetails,barberDto);

        BarberDto createdbarber = barberService.createBarber(barberDto);
        BeanUtils.copyProperties(createdbarber,returnValue);
        return returnValue;
    }

    @PutMapping
    public String updateUser()
    {
        return "update user was called";
    }

    @DeleteMapping
    public String deleteUser()
    {
        return "delete user was called";
    }

}
