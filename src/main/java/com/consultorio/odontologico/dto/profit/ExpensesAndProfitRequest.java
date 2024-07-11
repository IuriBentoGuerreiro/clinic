package com.consultorio.odontologico.dto.profit;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ExpensesAndProfitRequest {

    private LocalDate date;
    private String type;
    private String description;
    private Integer appointmentId;
    private Integer equipmentId;
}