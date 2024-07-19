package com.consultorio.odontologico.dto.equipment;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class EquipmentRequest {


    @NotBlank
    @Size(max = 100)
    private String name;
    @NotNull
    @PastOrPresent
    private LocalDate acquisitionDate;
    @NotNull
    @DecimalMin(value = "0.0", inclusive = false)
    private BigDecimal acquisitionValue;
    @NotNull
    @Min(1) 
    private Integer usageEstimate;
}