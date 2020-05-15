package com.barber.app.booking.repository;

import com.barber.app.booking.entity.Barber;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BarberRepository extends CrudRepository<Barber, Long> {
    Barber findBarberByFirstNameAndLastName(String firstName, String lastName);
    Barber findBarberByPhone(String Phone);
}
