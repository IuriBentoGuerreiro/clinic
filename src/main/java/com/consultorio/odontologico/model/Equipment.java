package com.consultorio.odontologico.model;

import com.consultorio.odontologico.dto.equipment.EquipmentRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Table(name = "equipment")
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Equipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "acquisition_date")
    private LocalDate acquisitionDate;
    @Column(name = "acquisition_value")
    private BigDecimal acquisitionValue;
    @Column(name = "usage_estimate")
    private Integer usageEstimate;

    public Equipment(Integer id){
        this.id = id;
    }

    @ManyToMany(mappedBy = "equipments")
    private List<Appointment> appointment;

    public static Equipment convert(EquipmentRequest equipmentRequest){
        return Equipment.builder()
                .name(equipmentRequest.getName())
                .acquisitionDate(equipmentRequest.getAcquisitionDate())
                .acquisitionValue(equipmentRequest.getAcquisitionValue())
                .usageEstimate(equipmentRequest.getUsageEstimate())
                .appointment(equipmentRequest.getAppointment().stream()
                        .map(Appointment::convert).toList())
                .build();
    }
}