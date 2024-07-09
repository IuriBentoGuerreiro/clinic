package com.consultorio.odontologico.dto.patient;

import com.consultorio.odontologico.model.Appointment;
import com.consultorio.odontologico.model.Patient;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
public class PatientResponse {

    private Integer id;
    private String name;
    private LocalDate dateBirth;
    private String address;
    private String phone;
    private String email;
    private List<Appointment> appointments;


    public static PatientResponse convert(Patient patient){
        return PatientResponse.builder()
                .id(patient.getId())
                .name(patient.getName())
                .dateBirth(patient.getDateBirth())
                .address(patient.getAddress())
                .phone(patient.getPhone())
                .email(patient.getEmail())
                .build();
    }
}