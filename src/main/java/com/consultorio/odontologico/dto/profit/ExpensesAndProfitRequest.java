package com.consultorio.odontologico.dto.profit;

import lombok.Data;

@Data
public class ExpensesAndProfitRequest {

    private Integer appointmentId;
    private Integer equipmentId;
}