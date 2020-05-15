package com.barber.app.booking.model.request;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ClientDetailsRequestModel {

    private String email;
    private String firstName;
    private String lastName;
    private String password;
    private String phone;
}
