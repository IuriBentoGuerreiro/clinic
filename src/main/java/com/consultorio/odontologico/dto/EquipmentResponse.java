package com.consultorio.odontologico.dto;

import com.consultorio.odontologico.model.Appointment;
import com.consultorio.odontologico.model.Equipment;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
@Builder
public class EquipmentResponse {

    private Integer id;
    private String name;
    private LocalDate acquisitionDate;
    private BigDecimal acquisitionValue;
    private Integer usageEstimate;
    private List<Appointment> appointment;

    public static EquipmentResponse convert(Equipment equipment){
        return EquipmentResponse.builder()
                .id(equipment.getId())
                .name(equipment.getName())
                .acquisitionDate(equipment.getAcquisitionDate())
                .acquisitionValue(equipment.getAcquisitionValue())
                .usageEstimate(equipment.getUsageEstimate())
                .appointment(equipment.getAppointment())
                .build();
    }
}