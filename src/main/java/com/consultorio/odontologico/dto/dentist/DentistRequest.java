package com.consultorio.odontologico.dto.dentist;

import com.consultorio.odontologico.model.Appointment;
import lombok.Data;

import java.util.List;

@Data
public class DentistRequest {

    private String name;
    private String specialty;
    private String crm;
    private String phone;
    private String email;
    private String workingHours;
    private List<Appointment> appointments;
}