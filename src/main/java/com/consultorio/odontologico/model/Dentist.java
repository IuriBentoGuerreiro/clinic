package com.consultorio.odontologico.model;

import com.consultorio.odontologico.dto.dentist.DentistRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Table(name = "dentist")
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Dentist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "specialty")
    private String specialty;
    @Column(name = "crm")
    private String crm;
    @Column(name = "phone")
    private String phone;
    @Column(name = "email")
    private String email;
    @Column(name = "working_hours")
    private String workingHours;

    @OneToMany(mappedBy = "dentist")
    private List<Appointment> appointments;

    public static Dentist convert(DentistRequest dentistRequest){
        return Dentist.builder()
                .name(dentistRequest.getName())
                .specialty(dentistRequest.getSpecialty())
                .crm(dentistRequest.getCrm())
                .phone(dentistRequest.getPhone())
                .email(dentistRequest.getEmail())
                .workingHours(dentistRequest.getWorkingHours())
                .appointments(dentistRequest.getAppointments())
                .build();
    }
}
