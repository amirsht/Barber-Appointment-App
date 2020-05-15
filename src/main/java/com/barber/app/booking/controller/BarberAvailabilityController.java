package com.barber.app.booking.controller;


import com.barber.app.booking.entity.BarberAvailability;
import com.barber.app.booking.model.request.BarberAvailabilityDetailsRequestModel;
import com.barber.app.booking.model.request.BarberDetailsRequestModel;
import com.barber.app.booking.service.implementation.BarberAvailabilityServiceImpl;
import com.barber.app.booking.service.implementation.BarberSlotServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hours")
public class BarberAvailabilityController {

    @Autowired
    BarberAvailabilityServiceImpl appointmentSlotService;


    @Autowired
    BarberSlotServiceImpl barberSlotService;


    @GetMapping
    public String getUser(@RequestBody BarberDetailsRequestModel barberDetails)
    {
        return "get user was celled";
    }

    @PostMapping
    public ResponseEntity createSlot(@RequestBody BarberAvailabilityDetailsRequestModel appointmentSlotDetails)
    {
        BarberAvailability createdSlot = appointmentSlotService.createSlot(appointmentSlotDetails);

        if(createdSlot == null)
            return new ResponseEntity(HttpStatus.FAILED_DEPENDENCY);

        barberSlotService.initSlots(createdSlot);

        return new ResponseEntity(HttpStatus.CREATED);

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
