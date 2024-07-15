package com.consultorio.odontologico.dto.dentist;

import lombok.Data;

@Data
public class DentistRequest {

    private String name;
    private String specialty;
    private String crm;
    private String phone;
    private String email;
    private String workingHours;
}