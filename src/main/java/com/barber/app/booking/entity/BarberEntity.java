package com.barber.app.booking.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "barbers")
@Getter
@Setter
@ToString(exclude = "serialVersionUID")
public class BarberEntity implements Serializable {

    private static final long serialVersionUID = 5993424019672200809L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="barber_id")
    private Long barberId;

    @Column(nullable = false, length = 50)
    private String firstName;

    @Column(nullable = false, length = 50)
    private String lastName;

    @Column(nullable = false, length = 50, unique = true)
    private String phone;

}
