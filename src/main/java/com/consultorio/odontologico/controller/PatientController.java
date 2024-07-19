package com.consultorio.odontologico.controller;

import com.consultorio.odontologico.dto.patient.PatientRequest;
import com.consultorio.odontologico.dto.patient.PatientResponse;
import com.consultorio.odontologico.service.PatientService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Patient")
@RestController
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @PostMapping
    public PatientResponse save(@RequestBody @Valid PatientRequest patientRequest){
        return patientService.save(patientRequest);
    }

    @GetMapping
    public List<PatientResponse> findAll(){
        return (patientService.findAll());
    }

    @GetMapping("/{id}")
    public PatientResponse findById(@PathVariable Integer id){
        return PatientResponse.convert(patientService.findById(id));
    }

    @PutMapping("/{id}")
    public PatientResponse update(@PathVariable Integer id, @RequestBody @Valid PatientRequest patientRequest){
        return PatientResponse.convert(patientService.update(id, patientRequest));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        patientService.deleteById(id);
    }
}
