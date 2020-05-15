package com.barber.app.booking.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.Date;

@Entity @IdClass(BarberSlot.BarberSlotId.class)
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class BarberSlot {


    @Id
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "dd/MM/yyyy")
    @OrderBy("workday ASC")
    private Date workday;

    @Id
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(nullable = false, name = "barber_id")
    private Barber barber;

    @Id
    @JsonFormat(pattern = "HH:mm:ss")
    private LocalTime startTime;

    @Id
    @JsonFormat(pattern = "HH:mm:ss")
    private LocalTime endTime;

    @Column(updatable = false)
    private Boolean isUsed;

    @Getter
    @NoArgsConstructor @AllArgsConstructor
    public static class BarberSlotId implements Serializable {

        private static final long serialVersionUID = 4653609311320879396L;
        private Date workday;
        private Long barber;
        private LocalTime startTime;
        private LocalTime endTime;
    }
}
