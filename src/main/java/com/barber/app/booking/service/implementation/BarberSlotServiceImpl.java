package com.barber.app.booking.service.implementation;

import com.barber.app.booking.entity.Barber;
import com.barber.app.booking.entity.BarberAvailability;
import com.barber.app.booking.entity.BarberSlot;
import com.barber.app.booking.model.request.BarberSlotDetailsRequestModel;
import com.barber.app.booking.model.response.BarberSlotRest;
import com.barber.app.booking.repository.BarberRepository;
import com.barber.app.booking.repository.BarberSlotRepository;
import com.barber.app.booking.service.BarberSlotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BarberSlotServiceImpl implements BarberSlotService {

    @Autowired
    BarberSlotRepository barberSlotRepository;

    @Autowired
    BarberRepository barberRepository;

    public void initSlots(BarberAvailability createdSlot) {

        List<BarberSlot> listSlot = new ArrayList<BarberSlot>();

        LocalTime time = createdSlot.getStartTime();

        do{
            listSlot.add(new BarberSlot(createdSlot.getWorkday(),createdSlot.getBarber(),time,time.plusMinutes(30),false));
            time = time.plusMinutes(30);
        }
        while(!time.equals(createdSlot.getEndTime()));

        for(BarberSlot bs : listSlot)
        {
            barberSlotRepository.save(bs);
        }


    }

    @Override
    public List<BarberSlotRest> getSlotsByDate(BarberSlotDetailsRequestModel requestModel) {

        Optional<Barber> barber = barberRepository.findById(requestModel.getBarber_id());
        Date workday = null;
        try {
            workday = new SimpleDateFormat("dd/MM/yyyy").parse(requestModel.getWorkday());
        } catch (Exception e)
        {
            e.printStackTrace();
        }

        //List<BarberSlot> barberSlots = barberSlotRepository.getBarberSlotsByBarberAndWorkday(barber.get(),workday,false);
        List<BarberSlot> barberSlots = barberSlotRepository.getBarberSlotsByBarberAndWorkdayAndIsUsed(barber.get(),workday,requestModel.getIsUsed());


        List<BarberSlotRest> barberSlotRestList = new ArrayList<>();

        for(BarberSlot barberSlot : barberSlots)
        {
            barberSlotRestList.add(new BarberSlotRest(barberSlot.getStartTime(),barberSlot.getEndTime()));
        }

        return barberSlotRestList;
    }
}
