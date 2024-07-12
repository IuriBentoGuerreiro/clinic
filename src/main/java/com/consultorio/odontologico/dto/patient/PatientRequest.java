package com.consultorio.odontologico.dto.patient;

import lombok.Data;

import java.time.LocalDate;

@Data
public class PatientRequest {

    private String name;
    private LocalDate dateBirth;
    private String address;
    private String phone;
    private String email;
}
