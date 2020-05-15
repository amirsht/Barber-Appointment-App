package com.barber.app.booking.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Time;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;


@Entity @IdClass(Appointment.AppointmentId.class)
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class Appointment implements Serializable{


    private static final long serialVersionUID = 5251410167849070711L;
    @Id
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(nullable = false, name = "client_id")
    private Client client;

    @Id
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(nullable = false, name = "barber_id")
    private Barber barber;

    @Id
    @JsonFormat(pattern = "dd/MM/yyyy")
    @Temporal(TemporalType.DATE)
    private Date date;

    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalTime startTime;

    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalTime endTime;


    @Getter
    @NoArgsConstructor @AllArgsConstructor
    public static class AppointmentId implements Serializable {

        private static final long serialVersionUID = 4422912451216571946L;

        private Long client;
        private Long barber;
        private Date date;
    }
}
