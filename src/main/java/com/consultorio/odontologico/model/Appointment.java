package com.consultorio.odontologico.model;

import com.consultorio.odontologico.dto.appointment.AppointmentRequest;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Table(name = "appointment")
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
    @JoinColumn(name = "patient_id")
    @JsonBackReference
    private Patient patient;
    @ManyToOne
    @JoinColumn(name = "dentist_id")
    @JsonBackReference
    private Dentist dentist;

    @Column(name = "payment")
    private String payment;
    @Column(name = "date_and_time")
    private LocalDateTime dateAndTime;
    @Column(name = "procedures")
    private String procedures;
    @Column(name = "total_cost")
    private BigDecimal totalCost;

    @ManyToMany
    @JsonBackReference
    private List<Equipment> equipments;
    @OneToMany(mappedBy = "appointment")
    @JsonBackReference
    private List<ExpensesAndProfit> expensesAndProfits;

    public Appointment(Integer id){
        this.id = id;
    }

    public static Appointment convert(AppointmentRequest appointmentRequest){
        return Appointment.builder()
                .patient(new Patient(appointmentRequest.getPatientId()))
                .dentist(new Dentist(appointmentRequest.getDentistId()))
                .payment(appointmentRequest.getPayment())
                .dateAndTime(appointmentRequest.getDateAndTime())
                .procedures(appointmentRequest.getProcedures())
                .totalCost(appointmentRequest.getTotalCost())
                .equipments(appointmentRequest.getEquipmentsId().stream()
                        .map(Equipment::new).toList())
                .build();
    }
}