package com.barber.app.booking.service.implementation;

import com.barber.app.booking.dto.ClientDto;
import com.barber.app.booking.entity.Client;
import com.barber.app.booking.repository.ClientRepository;
import com.barber.app.booking.service.ClientService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl implements ClientService {
    @Autowired
    ClientRepository clientRepository;

    @Override
    public ClientDto createUser(ClientDto user) {

        if(clientRepository.findClientByEmail(user.getEmail()) != null) throw new RuntimeException("Record already exists!");

        Client userEntity = new Client();
        BeanUtils.copyProperties(user,userEntity);

        userEntity.setEncryptedPassword(user.getPassword());
        Client storedUserDetails = clientRepository.save(userEntity);

        ClientDto returnValue = new ClientDto();
        BeanUtils.copyProperties(storedUserDetails,returnValue);

        return returnValue;
    }


}
