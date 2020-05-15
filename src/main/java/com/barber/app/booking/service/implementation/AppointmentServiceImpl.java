package com.barber.app.booking.service.implementation;

import com.barber.app.booking.entity.*;
import com.barber.app.booking.model.request.AppointmentDetailsRequestModel;
import com.barber.app.booking.repository.*;
import com.barber.app.booking.service.AppointmentService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

@Service
@Transactional
public class AppointmentServiceImpl implements AppointmentService {
    private static final Logger log = LogManager.getLogger(AppointmentServiceImpl.class);
    private static final String NOT_FOUND = "Appointment Slot not found";

    @Autowired
    AppointmentRepository appointmentRepository;

    @Autowired
    BarberRepository barberRepository;

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    BarberSlotRepository barberSlotRepository;

    @Override
    public Appointment createAppointment(AppointmentDetailsRequestModel details) {

        log.debug("Creating appointment for barber[id={}] and client[id={}] at {} to {}", details.getBarber(),
                details.getClient(), details.getStartTime(), details.getEndTime());

        Date workday = null;
        try {
            workday = new SimpleDateFormat("dd/MM/yyyy").parse(details.getDate());
        } catch (Exception e)
        {
            e.printStackTrace();
        }



        Optional<Client> client = clientRepository.findById(details.getClient());
        Optional<Barber> barber = barberRepository.findById(details.getBarber());


        //BarberSlot barberSlot = new BarberSlot(workday,barber.get(),details.getStartTime(),details.getEndTime(),true);
        //barberSlot = barberSlotRepository.save(barberSlot);
        //BarberSlot barberSlot = barberSlotRepository.getBarberSlotByBarberAndWorkdayAndStartTimeAndEndTime(barber.get(),workday,details.getStartTime(),details.getEndTime());
        //barberSlot.setIsUsed(true);
        //barberSlotRepository.save(barberSlot);

        barberSlotRepository.updateSlot(barber.get(),workday,details.getStartTime(),details.getEndTime());


        Appointment appointment = new Appointment(client.get(),barber.get(),workday,details.getStartTime(),details.getEndTime());
        return appointmentRepository.save(appointment);

    }
}
