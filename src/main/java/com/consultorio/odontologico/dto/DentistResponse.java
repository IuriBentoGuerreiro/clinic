package com.consultorio.odontologico.dto;

import com.consultorio.odontologico.model.Appointment;
import com.consultorio.odontologico.model.Dentist;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class DentistResponse {

    private Integer id;
    private String name;
    private String specialty;
    private String crm;
    private String phone;
    private String email;
    private String workingHours;
    private List<Appointment> appointments;

    public static DentistResponse convert(Dentist dentist){
        return DentistResponse.builder()
                .id(dentist.getId())
                .name(dentist.getName())
                .specialty(dentist.getSpecialty())
                .crm(dentist.getCrm())
                .phone(dentist.getPhone())
                .email(dentist.getEmail())
                .workingHours(dentist.getWorkingHours())
                .appointments(dentist.getAppointments())
                .build();
    }
}
