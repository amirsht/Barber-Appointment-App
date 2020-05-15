package com.barber.app.booking.model.request;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ClientLoginRequestModel {
    private String email;
    private String password;
}
