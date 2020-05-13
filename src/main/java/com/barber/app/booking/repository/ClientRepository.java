package com.barber.app.booking.repository;

import com.barber.app.booking.entity.ClientEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends CrudRepository<ClientEntity, Long> {
    ClientEntity findClientByEmail(String email);
}
