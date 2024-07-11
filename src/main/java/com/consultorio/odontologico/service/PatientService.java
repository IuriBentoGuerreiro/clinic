package com.consultorio.odontologico.service;

import com.consultorio.odontologico.dto.patient.PatientRequest;
import com.consultorio.odontologico.dto.patient.PatientResponse;
import com.consultorio.odontologico.model.Appointment;
import com.consultorio.odontologico.model.Patient;
import com.consultorio.odontologico.repository.PatientRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.webjars.NotFoundException;

import java.util.List;

@Service
public class PatientService {

    private final PatientRepository patientRepository;

    @Autowired
    public PatientService(PatientRepository patientRepository){
        this.patientRepository = patientRepository;
    }

    public PatientResponse save(PatientRequest patientRequest){
        var patient = patientRepository.save(Patient.builder()
                        .name(patientRequest.getName())
                        .phone(patientRequest.getPhone())
                        .email(patientRequest.getEmail())
                        .address(patientRequest.getAddress())
                        .dateBirth(patientRequest.getDateBirth())
                        .appointments(patientRequest.getAppointment().stream()
                                .map(Appointment::convert).toList())
                .build());

        return PatientResponse.convert(patient);
    }

    public List<PatientResponse> findAll(){
        return patientRepository.findAll().stream()
                .map(PatientResponse::convert).toList();
    }

    public Patient findById(Integer id){
        return patientRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Not found")
        );
    }

    public Patient update(Integer id, PatientRequest patientRequest){
        var patientSave = findById(id);
        BeanUtils.copyProperties(patientRequest, patientSave, "id");
        return patientRepository.save(patientSave);
    }

    public void deleteById(Integer id){
        patientRepository.deleteById(id);
    }
}
