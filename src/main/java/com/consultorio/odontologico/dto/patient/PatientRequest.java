package com.consultorio.odontologico.dto.patient;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDate;

@Data
public class PatientRequest {

    @NotBlank
    @Size(max = 100)
    private String name;
    @NotNull
    @Past
    private LocalDate dateBirth;
    @NotBlank
    @Size(max = 255)
    private String address;
    @NotBlank
    @Pattern(regexp = "\\(\\d{2}\\) \\d{4,5}-\\d{4}")
    private String phone;
    @NotBlank
    @Email
    private String email;
}
