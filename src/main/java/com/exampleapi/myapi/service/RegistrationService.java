package com.exampleapi.myapi.service;

import com.exampleapi.myapi.payload.RegistrationDto;

import java.util.List;


public interface RegistrationService {
    public RegistrationDto createRegistration(RegistrationDto regDto);
;

    void deleteRegistrationById(long id);

    RegistrationDto updateRegistration(long id, RegistrationDto registrationDto);

    List<RegistrationDto> getAllRegistration(int pageNo, int pageSize);
}
