package com.barber.app.booking.model.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;
import java.util.Date;

@Getter
@Setter
public class AppointmentDetailsRequestModel {

    private Long client;
    private Long barber;
    private String date;
    private LocalTime startTime;
    private LocalTime endTime;
}
