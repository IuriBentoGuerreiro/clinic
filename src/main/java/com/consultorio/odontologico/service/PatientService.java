package com.consultorio.odontologico.service;

import com.consultorio.odontologico.model.Patient;
import com.consultorio.odontologico.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    public Patient findById(Integer id){
        return patientRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Not found")
        );
    }
}
