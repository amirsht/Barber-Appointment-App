package com.barber.app.booking.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Entity(name = "apointments")
@Getter@Setter
public class ApointmentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="apointment_id")
    private int appointmentId;
    private String date;
    private String time;
    private String barberName;
    private String clientName;

}
