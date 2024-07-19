package com.consultorio.odontologico.dto.dentist;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class DentistRequest {

    @NotBlank
    @Size(max = 100)
    private String name;
    @NotBlank
    @Size(max = 100)
    private String specialty;
    @NotBlank
    @Size(max = 20)
    private String crm;
    @NotBlank
    @Pattern(regexp = "\\(\\d{2}\\) \\d{4,5}-\\d{4}")
    private String phone;
    @NotBlank
    @Email
    private String email;
    @NotBlank
    private String workingHours;
}