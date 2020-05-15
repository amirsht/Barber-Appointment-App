package com.barber.app.booking.repository;

import com.barber.app.booking.entity.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends CrudRepository<Client, Long> {
    Client findClientByEmail(String email);
}
