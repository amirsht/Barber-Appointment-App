package com.barber.app.booking.repository;

import com.barber.app.booking.entity.BarberEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BarberRepository extends CrudRepository<BarberEntity, Long> {
    BarberEntity findBarberByFirstNameAndLastName(String firstName,String lastName);
    BarberEntity findBarberByPhone(String Phone);
}
