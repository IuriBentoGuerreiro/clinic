package com.consultorio.odontologico.service;

import com.consultorio.odontologico.dto.equipment.EquipmentResponse;
import com.consultorio.odontologico.model.Appointment;
import com.consultorio.odontologico.repository.ExpensesAndProfitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class ExpensesAndProfitService {

    @Autowired
    private ExpensesAndProfitRepository expensesAndProfitRepository;

    @Autowired
    private EquipmentService equipmentService;

    public BigDecimal getProfitByEquipment(Integer equipmentId) {
        var equipment = equipmentService.findById(equipmentId);

        BigDecimal totalAppointmentsCost = equipment.getAppointment().stream()
                .map(Appointment::getTotalCost)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        return totalAppointmentsCost.subtract(equipment.getAcquisitionValue());
    }

    public String getAllExpense() {
        var totalCostEquipment = equipmentService.findAll().stream()
                .map(EquipmentResponse::getAcquisitionValue)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        return "Expenses equipments: " + totalCostEquipment;
    }

}
