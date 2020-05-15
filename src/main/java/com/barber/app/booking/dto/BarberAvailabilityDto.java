package com.barber.app.booking.dto;

import com.barber.app.booking.entity.Barber;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;


@Getter @Setter @NoArgsConstructor
public class BarberAvailabilityDto implements Serializable {

    private static final long serialVersionUID = -7325157626865005229L;
    private Date workday;
    private LocalTime startTime;
    private LocalTime endTime;
    private Long barber_id;

    public BarberAvailabilityDto(Date workday, LocalTime startlTime, LocalTime endTime, Long barber_id) {
        this.workday = workday;
        this.startTime = startlTime;
        this.endTime = endTime;
        this.barber_id = barber_id;
    }
}
