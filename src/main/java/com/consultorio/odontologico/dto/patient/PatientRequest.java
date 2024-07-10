package com.consultorio.odontologico.dto.patient;

import com.consultorio.odontologico.dto.appointment.AppointmentRequest;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class PatientRequest {

    private String name;
    private LocalDate dateBirth;
    private String address;
    private String phone;
    private String email;
    private List<AppointmentRequest> appointment;
}
