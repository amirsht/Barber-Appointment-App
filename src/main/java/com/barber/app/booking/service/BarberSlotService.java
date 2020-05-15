package com.barber.app.booking.service;

import com.barber.app.booking.entity.BarberSlot;
import com.barber.app.booking.model.request.BarberSlotDetailsRequestModel;
import com.barber.app.booking.model.response.BarberSlotRest;

import java.util.Date;
import java.util.List;

public interface BarberSlotService {

    public List<BarberSlotRest> getSlotsByDate(BarberSlotDetailsRequestModel requestModel);
}
