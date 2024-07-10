package com.consultorio.odontologico.service;

import com.consultorio.odontologico.dto.appointment.AppointmentRequest;
import com.consultorio.odontologico.dto.appointment.AppointmentResponse;
import com.consultorio.odontologico.model.Appointment;
import com.consultorio.odontologico.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    public AppointmentResponse save(AppointmentRequest appointmentRequest){
        return AppointmentResponse.convert(appointmentRepository.save(Appointment.convert(appointmentRequest)));
    }
}
