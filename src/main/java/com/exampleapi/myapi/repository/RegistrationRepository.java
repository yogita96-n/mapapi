package com.exampleapi.myapi.repository;

import com.exampleapi.myapi.entity.Registration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistrationRepository extends JpaRepository<Registration, Long> {
}