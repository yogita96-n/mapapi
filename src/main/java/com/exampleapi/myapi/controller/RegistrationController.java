package com.exampleapi.myapi.controller;

import com.exampleapi.myapi.entity.Registration;
import com.exampleapi.myapi.payload.PageDto;
import com.exampleapi.myapi.payload.RegistrationDto;
import com.exampleapi.myapi.service.RegistrationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/registration")
public class RegistrationController {
    public RegistrationService registrationService;

    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;

    }
    //http://localhost:8080/api/v1/registration


    @PostMapping
    public ResponseEntity<RegistrationDto> addRegistration (@RequestBody RegistrationDto regDto){
        RegistrationDto dto = registrationService.createRegistration(regDto);
        return new ResponseEntity<>(dto,HttpStatus.CREATED);
    }

    // http://localhost:8080/api/v1/registration?id
    @DeleteMapping
    public ResponseEntity<String> deleteRegistrationById
    (@RequestParam long id) {
        registrationService.deleteRegistrationById(id);
        return new ResponseEntity<>("RECORDS DELETED", HttpStatus.OK);
    }
    @PutMapping
    public ResponseEntity<RegistrationDto>updateRegistration(@RequestParam long id,@RequestBody RegistrationDto registrationDto){
        RegistrationDto regDto=registrationService.updateRegistration(id,registrationDto);
        return new ResponseEntity<>(regDto,HttpStatus.OK);
    }
    //http://localhost:8080/api/v1/registration?pageNo=&pageSize
    @GetMapping
    public PageDto getAllregistrations(
            @RequestParam(name="pageNo",defaultValue = "0",required = false)int pageNo,
            @RequestParam(name="pageSize",defaultValue = "5",required = false)int pageSize){
        List<RegistrationDto> dto = registrationService.getAllRegistration(pageNo,pageSize);
        dto.toArray()

        return pageDto
                ;
    }
}
