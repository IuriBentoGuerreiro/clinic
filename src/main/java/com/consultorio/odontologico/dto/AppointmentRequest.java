package com.consultorio.odontologico.dto;

import com.consultorio.odontologico.model.Dentist;
import com.consultorio.odontologico.model.Equipment;
import com.consultorio.odontologico.model.ExpensesAndProfits;
import com.consultorio.odontologico.model.Patient;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class AppointmentRequest {

    private Patient patient;
    private Dentist dentist;
    private String payment;
    private LocalDateTime dateAndTime;
    private String procedures;
    private BigDecimal totalCost;
    private List<Equipment> equipments;
    private List<ExpensesAndProfits> expensesAndProfits;
}
