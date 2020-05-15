package com.barber.app.booking.repository;


import com.barber.app.booking.entity.BarberAvailability;
import com.barber.app.booking.entity.Barber;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface BarberAvailabilityRepository extends CrudRepository<BarberAvailability, Long>{

    BarberAvailability findAppointmentSlotByWorkdayAndBarber(Date date, Barber barber);



}
