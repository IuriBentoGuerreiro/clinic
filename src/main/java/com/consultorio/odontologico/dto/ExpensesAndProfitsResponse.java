package com.consultorio.odontologico.dto;

import com.consultorio.odontologico.model.Appointment;
import com.consultorio.odontologico.model.Equipment;
import com.consultorio.odontologico.model.ExpensesAndProfits;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class ExpensesAndProfitsResponse {

    private Integer id;
    private LocalDate date;
    private String type;
    private String description;
    private Appointment appointment;
    private Equipment equipment;

    public static ExpensesAndProfitsResponse convert(ExpensesAndProfits expensesAndProfits){
        return ExpensesAndProfitsResponse.builder()
                .id(expensesAndProfits.getId())
                .date(expensesAndProfits.getDate())
                .type(expensesAndProfits.getType())
                .description(expensesAndProfits.getDescription())
                .appointment(expensesAndProfits.getAppointment())
                .equipment(expensesAndProfits.getEquipment())
                .build();
    }
}