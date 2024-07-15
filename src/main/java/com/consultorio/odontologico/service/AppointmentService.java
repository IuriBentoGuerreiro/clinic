package com.consultorio.odontologico.service;

import com.consultorio.odontologico.dto.appointment.AppointmentRequest;
import com.consultorio.odontologico.dto.appointment.AppointmentResponse;
import com.consultorio.odontologico.model.Appointment;
import com.consultorio.odontologico.repository.AppointmentRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final PatientService patientService;
    private final DentistService dentistService;
    private final EquipmentService equipmentService;
    private final ExpensesAndProfitService expensesAndProftService;

    @Autowired
    public AppointmentService(AppointmentRepository appointmentRepository,
                              PatientService patientService,
                              DentistService dentistService,
                              EquipmentService equipmentService,
                              ExpensesAndProfitService expensesAndProftService) {
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

    public List<AppointmentResponse> findAll(){
        return appointmentRepository.findAll().stream()
                .map(AppointmentResponse::convert).toList();
    }

    public Appointment findById(Integer id){
        return appointmentRepository.findById(id).orElseThrow(
                ()-> new NotFoundException("Not found")
        );
    }

    public Appointment update(Integer id, AppointmentRequest appointmentRequest){
        var appointmentSave = findById(id);
        BeanUtils.copyProperties(appointmentRequest, appointmentSave, "id");
        return appointmentRepository.save(appointmentSave);
    }

    public void deleteById(Integer id){
        appointmentRepository.deleteById(id);
    }

    private Appointment addAppointment(AppointmentRequest appointmentRequest){
        var appointment = Appointment.builder()
                .patient(patientService.findById(appointmentRequest.getPatientId()))
                .dentist(dentistService.findById(appointmentRequest.getDentistId()))
                .procedures(appointmentRequest.getProcedures())
                .totalCost(appointmentRequest.getTotalCost())
                .payment(appointmentRequest.getPayment())
                .dateAndTime(LocalDateTime.now())
                .equipments(equipmentService.findAllById(appointmentRequest.getEquipmentsId()))
                .expensesAndProfits(expensesAndProftService.findAllById(appointmentRequest.getExpensesAndProfitsId()))
                .build();

        return appointmentRepository.save(appointment);
    }
}