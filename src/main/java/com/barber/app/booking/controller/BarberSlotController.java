package com.barber.app.booking.controller;


import com.barber.app.booking.model.request.BarberSlotDetailsRequestModel;
import com.barber.app.booking.model.response.BarberSlotRest;
import com.barber.app.booking.service.implementation.BarberSlotServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/slots")
public class BarberSlotController {

    @Autowired
    BarberSlotServiceImpl barberSlotService;



    @GetMapping
    public List<BarberSlotRest> getSlotsByDate(@RequestBody BarberSlotDetailsRequestModel barberSlotDetailsRequestModel)
    {
        List<BarberSlotRest> barberSlots = barberSlotService.getSlotsByDate(barberSlotDetailsRequestModel);
        return barberSlots;
    }


}
