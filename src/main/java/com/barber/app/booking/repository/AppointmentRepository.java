package com.barber.app.booking.repository;

import com.barber.app.booking.entity.Appointment;
import com.barber.app.booking.entity.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.Optional;

@Repository
public interface AppointmentRepository  extends CrudRepository<Appointment, Long> {

    Appointment findByClientAndDateIsAfter(Client client, Date today);
}
