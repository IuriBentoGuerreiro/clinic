package com.consultorio.odontologico.dto.profit;

import com.consultorio.odontologico.model.Appointment;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ExpensesAndProfitsRequest {

    private LocalDate date;
    private String type;
    private String description;
    private Integer appointmentId;
    private Integer equipmentId;
}