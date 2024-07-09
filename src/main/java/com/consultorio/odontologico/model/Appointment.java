package com.consultorio.odontologico.model;

import com.consultorio.odontologico.dto.appointment.AppointmentRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

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

    @ManyToMany
    private List<Equipment> equipments;
    @OneToMany(mappedBy = "appointment")
    private List<ExpensesAndProfits> expensesAndProfits;

    public static Appointment convert(AppointmentRequest appointmentRequest){
        return Appointment.builder()
                .patient(appointmentRequest.getPatient())
                .dentist(appointmentRequest.getDentist())
                .payment(appointmentRequest.getPayment())
                .dateAndTime(appointmentRequest.getDateAndTime())
                .procedures(appointmentRequest.getProcedures())
                .totalCost(appointmentRequest.getTotalCost())
                .expensesAndProfits(appointmentRequest.getExpensesAndProfits())
                .build();
    }
}