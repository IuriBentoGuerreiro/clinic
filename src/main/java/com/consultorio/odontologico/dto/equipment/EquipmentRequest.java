package com.consultorio.odontologico.dto.equipment;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class EquipmentRequest {

    private String name;
    private LocalDate acquisitionDate;
    private BigDecimal acquisitionValue;
    private Integer usageEstimate;
}