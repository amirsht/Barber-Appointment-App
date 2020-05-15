package com.barber.app.booking.service;

import com.barber.app.booking.entity.BarberAvailability;
import com.barber.app.booking.entity.Barber;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

public interface BarberAvailabilityService {

    void addAppointmentSlot(Barber barber, Date workday , LocalTime startTime, LocalTime endTime);

    List<BarberAvailability> getAppointmentSlotsBetween(Barber barber, LocalDateTime startTime, LocalDateTime endTime);

}
