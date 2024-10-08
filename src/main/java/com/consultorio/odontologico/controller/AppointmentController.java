package com.consultorio.odontologico.controller;

import com.consultorio.odontologico.dto.appointment.AppointmentRequest;
import com.consultorio.odontologico.dto.appointment.AppointmentResponse;
import com.consultorio.odontologico.service.AppointmentService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Appointment")
@RestController
@RequestMapping("/appointment")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @PostMapping
    public AppointmentResponse save(@RequestBody @Valid AppointmentRequest appointmentRequest){
        return appointmentService.save(appointmentRequest);
    }

    @GetMapping
    public List<AppointmentResponse> findAll(){
        return appointmentService.findAll();
    }

    @GetMapping("/{id}")
    public AppointmentResponse findById(@PathVariable Integer id){
        return AppointmentResponse.convert(appointmentService.findById(id));
    }

    @PutMapping("/{id}")
    public AppointmentResponse update(@PathVariable Integer id, @RequestBody @Valid AppointmentRequest appointmentRequest){
        return AppointmentResponse.convert(appointmentService.update(id, appointmentRequest));
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id){
        appointmentService.deleteById(id);
    }
}