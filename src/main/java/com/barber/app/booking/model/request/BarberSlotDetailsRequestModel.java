package com.barber.app.booking.model.request;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class BarberSlotDetailsRequestModel {
    private String workday;
    private Long barber_id;
    private Boolean isUsed;
}
