package com.barber.app.booking.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import java.io.Serializable;

@Getter @Setter
@ToString(exclude="serialVersionUID")
public class ClientDto implements Serializable {

    private static final long serialVersionUID = 2591154119977123124L;

    private Long id;
    private String email;
    private String firstName;
    private String lastName;
    private String phone;
    private String password;
    private String emailVerificationToken;
    private Boolean emailVerificationStatus = false;
}
