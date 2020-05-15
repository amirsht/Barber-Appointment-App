package com.barber.app.booking.controller;

import com.barber.app.booking.dto.BarberAvailabilityDto;
import com.barber.app.booking.entity.Appointment;
import com.barber.app.booking.model.request.AppointmentDetailsRequestModel;
import com.barber.app.booking.model.request.BarberAvailabilityDetailsRequestModel;
import com.barber.app.booking.service.AppointmentService;
import com.barber.app.booking.service.implementation.AppointmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {

    @Autowired
    AppointmentServiceImpl appointmentService;

    @PostMapping
    public ResponseEntity createAppointment(@RequestBody AppointmentDetailsRequestModel appointmentDetailsRequestModel)
    {

        Appointment appointment =  appointmentService.createAppointment(appointmentDetailsRequestModel);


        if(appointment != null)
            return new ResponseEntity(HttpStatus.CREATED);
        return new ResponseEntity(HttpStatus.FAILED_DEPENDENCY);
    }

}
