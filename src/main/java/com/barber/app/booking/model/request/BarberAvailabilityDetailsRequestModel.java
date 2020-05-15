package com.barber.app.booking.model.request;

import com.barber.app.booking.entity.Barber;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

@Getter
@Setter
public class BarberAvailabilityDetailsRequestModel {

    private String workday;
    private String startTime;
    private String endTime;
    private Long barber_id;
    private Long client_id;
}
