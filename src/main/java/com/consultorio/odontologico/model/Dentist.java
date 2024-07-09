package com.consultorio.odontologico.model;

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

    public static Dentist convert(){
        //TODO fazer metodo build
        return null;
    }
}
