package com.barber.app.booking.controller;

import com.barber.app.booking.dto.ClientDto;
import com.barber.app.booking.model.request.UserDetailsRequestModel;
import com.barber.app.booking.model.response.UserRest;
import com.barber.app.booking.service.ClientService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/users")
public class ClientController {

    @Autowired
    ClientService clientService;

    @GetMapping
    public String getUser()
    {
        return "get user was celled";
    }

    @PostMapping
    public UserRest createUser(@RequestBody UserDetailsRequestModel userDetails)
    {
        UserRest returnValue = new UserRest();

        ClientDto userDto = new ClientDto();
        BeanUtils.copyProperties(userDetails,userDto);

        ClientDto createdUser = clientService.createUser(userDto);
        BeanUtils.copyProperties(createdUser,returnValue);
        return returnValue;
    }

    @PutMapping
    public String updateUser()
    {
        return "update user was called";
    }

    @DeleteMapping
    public String deleteUser()
    {
        return "delete user was called";
    }
}
