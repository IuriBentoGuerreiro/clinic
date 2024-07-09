package com.consultorio.odontologico.dto.appointment;

import com.consultorio.odontologico.model.*;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class AppointmentResponse {

    private Integer id;
    private Patient patient;
    private Dentist dentist;
    private String payment;
    private LocalDateTime dateAndTime;
    private String procedures;
    private BigDecimal totalCost;
    private List<Equipment> equipments;
    private List<ExpensesAndProfits> expensesAndProfits;

    public static AppointmentResponse convert(Appointment appointment){
        return AppointmentResponse.builder()
                .id(appointment.getId())
                .patient(appointment.getPatient())
                .dentist(appointment.getDentist())
                .payment(appointment.getPayment())
                .dateAndTime(appointment.getDateAndTime())
                .procedures(appointment.getProcedures())
                .totalCost(appointment.getTotalCost())
                .equipments(appointment.getEquipments())
                .expensesAndProfits(appointment.getExpensesAndProfits())
                .build();
    }
}