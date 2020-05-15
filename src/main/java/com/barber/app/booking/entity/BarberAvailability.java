package com.barber.app.booking.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalTime;
import java.util.Date;


@Entity @IdClass(BarberAvailability.BarberAvailabilityId.class)
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class BarberAvailability implements Serializable {

    private static final long serialVersionUID = 3109640376799780591L;

    @Id
    @OrderBy
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date workday;

    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalTime startTime;

    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalTime endTime;

    @Id
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(nullable = false, name = "barber_id")
    private Barber barber;


    @Getter
    @NoArgsConstructor @AllArgsConstructor
    public static class BarberAvailabilityId implements Serializable {

        private static final long serialVersionUID = 2063710829789212004L;
        private Date workday;
        private Long barber;
    }
}
