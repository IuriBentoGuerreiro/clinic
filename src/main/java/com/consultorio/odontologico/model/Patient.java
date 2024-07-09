package com.consultorio.odontologico.model;

import com.consultorio.odontologico.dto.PatientRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Table(name = "patient")
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "date_birth")
    private LocalDate dateBirth;
    @Column(name = "address")
    private String address;
    @Column(name = "phone")
    private String phone;
    @Column(name = "email")
    private String email;

    @OneToMany(mappedBy = "patient")
    private List<Appointment> appointments;

    public static Patient convert(PatientRequest patientRequest){
        return Patient.builder()
                .name(patientRequest.getName())
                .dateBirth(patientRequest.getDateBirth())
                .address(patientRequest.getAddress())
                .phone(patientRequest.getPhone())
                .email(patientRequest.getEmail())
                .build();
    }
}