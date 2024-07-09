package com.consultorio.odontologico.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Table(name = "expenses_and_profits")
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ExpensesAndProfits {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "date")
    private LocalDate date;
    @Column(name = "type")
    private String type;
    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "appointment_id")
    private Appointment appointment;
    @ManyToOne
    @JoinColumn(name = "equipment_id")
    private Equipment equipment;


    public static ExpensesAndProfits convert(){
        //TODO fazer metodo build
        return null;
    }
}