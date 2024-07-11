package com.consultorio.odontologico.service;

import com.consultorio.odontologico.dto.appointment.AppointmentRequest;
import com.consultorio.odontologico.dto.appointment.AppointmentResponse;
import com.consultorio.odontologico.model.Appointment;
import com.consultorio.odontologico.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final PatientService patientService;
    private final DentistService dentistService;
    private final EquipmentService equipmentService;
    private final ExpensesAndProftService expensesAndProftService;

    @Autowired
    public AppointmentService(AppointmentRepository appointmentRepository,
                              PatientService patientService,
                              DentistService dentistService,
                              EquipmentService equipmentService,
                              ExpensesAndProftService expensesAndProftService) {
        this.appointmentRepository = appointmentRepository;
        this.patientService = patientService;
        this.dentistService = dentistService;
        this.equipmentService = equipmentService;
        this.expensesAndProftService = expensesAndProftService;
    }

    public AppointmentResponse save(AppointmentRequest appointmentRequest){
        var appointment = appointmentRepository.save(Appointment.builder()
                        .patient(patientService.findById(appointmentRequest.getPatientId()))
                        .dentist(dentistService.findById(appointmentRequest.getDentistId()))
                        .procedures(appointmentRequest.getProcedures())
                        .totalCost(appointmentRequest.getTotalCost())
                        .payment(appointmentRequest.getPayment())
                        .dateAndTime(LocalDateTime.now())
                        .equipments(equipmentService.findAllById(appointmentRequest.getEquipmentsId()))
                        .expensesAndProfits(expensesAndProftService.findAllById(appointmentRequest.getExpensesAndProfitsId()))
                .build());

        return AppointmentResponse.convert(appointment);
    }
}
