package com.consultorio.odontologico.dto;

import com.consultorio.odontologico.model.Patient;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class PatientResponse {

    private Integer id;
    private String name;
    private LocalDate dateBirth;
    private String address;
    private String phone;
    private String email;

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