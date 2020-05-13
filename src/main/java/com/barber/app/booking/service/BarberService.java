package com.barber.app.booking.service;

import com.barber.app.booking.dto.BarberDto;
import com.barber.app.booking.dto.ClientDto;
import com.barber.app.booking.entity.BarberEntity;
import com.barber.app.booking.entity.ClientEntity;
import com.barber.app.booking.repository.BarberRepository;
import com.barber.app.booking.repository.ClientRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BarberService {
    @Autowired
    BarberRepository barberRepository;

    public BarberDto createBarber(BarberDto barber) {

        if(barberRepository.findBarberByPhone(barber.getPhone()) != null) throw new RuntimeException("No way - this phone is exist already!");

        BarberEntity barberEntity = new BarberEntity();
        BeanUtils.copyProperties(barber,barberEntity);

        BarberEntity storedBarberDetails = barberRepository.save(barberEntity);

        BarberDto returnValue = new BarberDto();
        BeanUtils.copyProperties(storedBarberDetails,returnValue);

        return returnValue;
    }


}
