package com.barber.app.booking.service.implementation;

import com.barber.app.booking.dto.BarberDto;
import com.barber.app.booking.entity.Barber;
import com.barber.app.booking.repository.BarberRepository;
import com.barber.app.booking.service.BarberService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BarberServiceImpl implements BarberService {
    @Autowired
    BarberRepository barberRepository;

    @Override
    public BarberDto createBarber(BarberDto barber) {

        if(barberRepository.findBarberByPhone(barber.getPhone()) != null) throw new RuntimeException("No way - this phone is exist already!");

        Barber barberEntity = new Barber();
        BeanUtils.copyProperties(barber,barberEntity);

        Barber storedBarberDetails = barberRepository.save(barberEntity);

        BarberDto returnValue = new BarberDto();
        BeanUtils.copyProperties(storedBarberDetails,returnValue);

        return returnValue;
    }


}
