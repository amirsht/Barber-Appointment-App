package com.barber.app.booking.model.response;

import com.barber.app.booking.entity.Barber;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;


@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class BarberSlotRest {
    private LocalTime startTime;
    private LocalTime endTime;
}
