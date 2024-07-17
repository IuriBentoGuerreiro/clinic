package com.consultorio.odontologico.dto.profit;

import com.consultorio.odontologico.model.Appointment;
import com.consultorio.odontologico.model.Equipment;
import com.consultorio.odontologico.model.ExpensesAndProfit;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
public class ExpensesAndProfitResponse {

    private Integer id;
    private LocalDate date;
    private String type;
    private String description;
    private Appointment appointment;
    private Equipment equipment;
    private BigDecimal profits;

    public static ExpensesAndProfitResponse convert(ExpensesAndProfit expensesAndProfits){
        return ExpensesAndProfitResponse.builder()
                .id(expensesAndProfits.getId())
                .date(expensesAndProfits.getDate())
                .type(expensesAndProfits.getType())
                .description(expensesAndProfits.getDescription())
                .appointment(expensesAndProfits.getAppointment())
                .equipment(expensesAndProfits.getEquipment())
                .profits(expensesAndProfits.getProfit())
                .build();
    }
}