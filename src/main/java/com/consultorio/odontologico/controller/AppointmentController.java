package com.consultorio.odontologico.controller;

import com.consultorio.odontologico.dto.appointment.AppointmentRequest;
import com.consultorio.odontologico.dto.appointment.AppointmentResponse;
import com.consultorio.odontologico.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @PostMapping
    public AppointmentResponse save(@RequestBody AppointmentRequest appointmentRequest){
        return appointmentService.save(appointmentRequest);
    }
}
