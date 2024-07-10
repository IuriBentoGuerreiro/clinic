package com.consultorio.odontologico.dto.equipment;

import com.consultorio.odontologico.dto.appointment.AppointmentRequest;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
public class EquipmentRequest {

    private String name;
    private LocalDate acquisitionDate;
    private BigDecimal acquisitionValue;
    private Integer usageEstimate;
    private List<AppointmentRequest> appointment;
}