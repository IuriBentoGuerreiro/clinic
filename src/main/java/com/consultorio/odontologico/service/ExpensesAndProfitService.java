package com.consultorio.odontologico.service;

import com.consultorio.odontologico.dto.appointment.AppointmentResponse;
import com.consultorio.odontologico.dto.equipment.EquipmentResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class ExpensesAndProfitService {

    @Autowired
    private AppointmentService appointmentService;

    @Autowired
    private EquipmentService equipmentService;

    public String getAllExpense() {
        var totalCostEquipment = equipmentService.findAll().stream()
                .map(EquipmentResponse::getAcquisitionValue)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        return "Expenses equipments: " + totalCostEquipment;
    }

    public String getAllProfit(){
        var totalCostAppointment = appointmentService.findAll().stream()
                .map(AppointmentResponse::getTotalCost)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        return "Gross profit: " + totalCostAppointment;
    }

    public String getAllExpensesProfit() {
        var totalCostEquipment = equipmentService.findAll().stream()
                .map(EquipmentResponse::getAcquisitionValue)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        var totalCostAppointment = appointmentService.findAll().stream()
                .map(AppointmentResponse::getTotalCost)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        return "Expenses and Profits: " + totalCostAppointment.subtract(totalCostEquipment);
    }

}
