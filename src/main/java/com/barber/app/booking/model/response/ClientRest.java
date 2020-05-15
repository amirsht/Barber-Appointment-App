package com.barber.app.booking.model.response;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ClientRest {

    private Long id;
    private String email;
    private String firstName;
    private String lastName;
    private String phone;
}
