package com.exampleapi.myapi.service;

import com.exampleapi.myapi.entity.Registration;
import com.exampleapi.myapi.payload.RegistrationDto;
import com.exampleapi.myapi.repository.RegistrationRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RegistrationServiceImpl implements  RegistrationService{

    public RegistrationRepository registrationRepository;

    public RegistrationServiceImpl(RegistrationRepository registrationRepository) {
        this.registrationRepository = registrationRepository;
    }


    @Override
    public RegistrationDto createRegistration(RegistrationDto registrationDto) {
        Registration reg = mapToEntity(registrationDto);
        Registration saveEntity = registrationRepository.save(reg);

        RegistrationDto Dto = mapToDto(reg);
        registrationDto.setMessage("Registration is successfully!!!");


        return Dto;
    }



    @Override
    public void deleteRegistrationById(long id) {

        registrationRepository.deleteById(id);
    }

    @Override
    public RegistrationDto updateRegistration(long id, RegistrationDto registrationDto) {
        Optional<Registration> opReg = registrationRepository.findById(id);
        Registration registration = opReg.get();
        registration.setName(registrationDto.getName());
        registration.setEmail(registrationDto.getEmail());
registration.setMobile(registrationDto.getMobile());
        Registration saveEntity = registrationRepository.save(registration);
        RegistrationDto dto = mapToDto(registration);
return dto;
    }

    @Override
    public List<RegistrationDto> getAllRegistration(int pageNo, int pageSize) {
        //List<Registration> registrations = registrationRepository.findAll();
        PageRequest pageable = PageRequest.of(pageNo, pageSize);
        Page<Registration> all = registrationRepository.findAll(pageable);
        List<Registration> registrations = all.getContent();
        List<RegistrationDto> registrationDtos = registrations.stream().map(r -> mapToDto(r)).collect(Collectors.toList());//covert all dtos to registration
        return registrationDtos;
    }

    Registration mapToEntity(RegistrationDto regDto){
        Registration  entity =new Registration();
        entity.setName(regDto.getName());
        entity.setEmail(regDto.getEmail());
        entity.setMobile(regDto.getMobile());
        return entity;
    }
    RegistrationDto mapToDto(Registration reg){
        RegistrationDto  registrationDto =new RegistrationDto();
        registrationDto.setName(reg.getName());
        registrationDto.setEmail(reg.getEmail());
        registrationDto.setMobile(reg.getMobile());

        return registrationDto;
    }

}
