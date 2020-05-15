package com.barber.app.booking.service;

import com.barber.app.booking.entity.Appointment;
import com.barber.app.booking.entity.BarberAvailability;
import com.barber.app.booking.entity.Barber;
import com.barber.app.booking.entity.Client;
import com.barber.app.booking.model.request.AppointmentDetailsRequestModel;

public interface AppointmentService {

    Appointment createAppointment(AppointmentDetailsRequestModel appointmentDetailsRequestModel);
}
