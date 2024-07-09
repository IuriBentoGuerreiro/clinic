package com.consultorio.odontologico.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Table(name = "appoinment")
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    private Patient patient;
    @ManyToOne
    private Dentist dentist;

    @Column(name = "payment")
    private String payment;
    @Column(name = "date_and_time")
    private LocalDateTime dateAndTime;
    @Column(name = "procedures")
    private String procedures;
    @Column(name = "total_cost")
    private BigDecimal totalCost;

    public static Appointment convert(){
        //TODO fazer metodo build
        return null;
    }
}