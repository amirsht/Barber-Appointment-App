package com.barber.app.booking.service.implementation;

import com.barber.app.booking.dto.BarberAvailabilityDto;
import com.barber.app.booking.entity.BarberAvailability;
import com.barber.app.booking.entity.Barber;
import com.barber.app.booking.model.request.BarberAvailabilityDetailsRequestModel;
import com.barber.app.booking.repository.BarberAvailabilityRepository;
import com.barber.app.booking.repository.BarberRepository;
import com.barber.app.booking.service.BarberAvailabilityService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BarberAvailabilityServiceImpl implements BarberAvailabilityService {

    @Autowired
    BarberAvailabilityRepository barberAvailabilityRepository;

    @Autowired
    BarberRepository barberRepository;

    @Override
    public void addAppointmentSlot(Barber barber, Date workday ,LocalTime startTime, LocalTime endTime) {
        BarberAvailability barberAvailability = new BarberAvailability(workday,startTime, endTime, barber);
    }

    @Override
    public List<BarberAvailability> getAppointmentSlotsBetween(Barber barber, LocalDateTime startTime, LocalDateTime endTime) {
        return null;
        //return appointmentSlotRepository.getAppointmentSlotsBetween(barber, startTime, endTime);
    }


    public BarberAvailability createSlot(BarberAvailabilityDetailsRequestModel appointmentSlotDetails)  {


        Date workday = null;
        try {
            workday = new SimpleDateFormat("dd/MM/yyyy").parse(appointmentSlotDetails.getWorkday());
        } catch (Exception e)
        {
            e.printStackTrace();
        }

        // Check if this entry is exist in table
        Optional<Barber> barber = barberRepository.findById(appointmentSlotDetails.getBarber_id());
        if(barberAvailabilityRepository.findAppointmentSlotByWorkdayAndBarber(workday,barber.get()) != null) throw new RuntimeException("This day is already exists!");

        // Parsing string to LocalTime
        LocalTime startlTime = LocalTime.parse(appointmentSlotDetails.getStartTime());
        LocalTime endTime= LocalTime.parse(appointmentSlotDetails.getEndTime());


        BarberAvailability barberAvailability = new BarberAvailability(workday,startlTime,endTime,barber.get());

        BarberAvailability storedBarberAvailabilityDetails = barberAvailabilityRepository.save(barberAvailability);

        return storedBarberAvailabilityDetails;
    }
}