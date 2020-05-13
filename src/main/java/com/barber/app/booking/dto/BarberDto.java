package com.barber.app.booking.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@ToString(exclude="serialVersionUID")
public class BarberDto  implements Serializable {
    private static final long serialVersionUID = 3442688945808143136L;

    private Long barberId;
    private String firstName;
    private String lastName;
    private String phone;
}
