package com.exampleapi.myapi.payload;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter


public class RegistrationDto {

    private Long id;


    private String name;


    private String email;

    private String mobile;

    private String message;

}