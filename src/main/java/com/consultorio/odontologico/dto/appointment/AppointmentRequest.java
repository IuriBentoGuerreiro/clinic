package com.consultorio.odontologico.dto.appointment;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class AppointmentRequest {

    @NotNull
    private Integer patientId;
    @NotNull
    private Integer dentistId;
    @NotBlank
    private String payment;
    @NotNull
    private LocalDateTime dateAndTime;
    @NotBlank
    private String procedures;
    @NotNull
    @DecimalMin(value = "0.0", inclusive = false)
    private BigDecimal totalCost;
    @NotEmpty
    private List<@NotNull Integer> equipmentsId;
}
