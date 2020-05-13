package com.barber.app.booking.service;

import com.barber.app.booking.dto.ClientDto;
import com.barber.app.booking.entity.ClientEntity;
import com.barber.app.booking.repository.ClientRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {
    @Autowired
    ClientRepository clientRepository;

    public ClientDto createUser(ClientDto user) {

        if(clientRepository.findClientByEmail(user.getEmail()) != null) throw new RuntimeException("Record already exists!");

        ClientEntity userEntity = new ClientEntity();
        BeanUtils.copyProperties(user,userEntity);

        userEntity.setEncryptedPassword(user.getPassword());
        ClientEntity storedUserDetails = clientRepository.save(userEntity);

        ClientDto returnValue = new ClientDto();
        BeanUtils.copyProperties(storedUserDetails,returnValue);

        return returnValue;
    }


}
