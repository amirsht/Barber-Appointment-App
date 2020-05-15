package com.barber.app.booking.model.response;

import com.barber.app.booking.entity.Barber;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
public class BarberAvailabilityRest {

    private Date workday;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Barber barber;
}
