package com.barber.app.booking.repository;

import com.barber.app.booking.entity.Barber;
import com.barber.app.booking.entity.BarberSlot;
import com.barber.app.booking.model.response.BarberSlotRest;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalTime;
import java.util.Date;
import java.util.List;

@Repository
public interface BarberSlotRepository  extends CrudRepository<BarberSlot, Long> {
    List<BarberSlot> getBarberSlotsByBarberAndWorkdayAndIsUsed(Barber barber, Date date,Boolean isUsed);

    BarberSlot getBarberSlotByBarberAndWorkdayAndStartTimeAndEndTime(Barber barber, Date date, LocalTime startTime,LocalTime endTime);

    //@Query("select * from BarberSlot bs where (bs.barber= ?1 and bs.workday= ?2)")
    //List<BarberSlot> getSomething(Barber barber, Date date);

    @Query("update BarberSlot bs set bs.isUsed=true where (bs.barber= ?1 AND bs.workday= ?2 AND bs.startTime= ?3 AND bs.endTime= ?4)")
    @Modifying
    void updateSlot(Barber barber, Date workday, LocalTime startTime,LocalTime endTime);


}
