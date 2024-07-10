package com.consultorio.odontologico.dto.appointment;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class AppointmentRequest {

    private Integer patientId;
    private Integer dentistId;
    private String payment;
    private LocalDateTime dateAndTime;
    private String procedures;
    private BigDecimal totalCost;
    private List<Integer> equipmentsId;
    private List<Integer> expensesAndProfitsId;
}
