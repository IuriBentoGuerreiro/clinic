package com.consultorio.odontologico.service;

import com.consultorio.odontologico.model.Dentist;
import com.consultorio.odontologico.repository.DentistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

@Service
public class DentistService {

    @Autowired
    private DentistRepository dentistRepository;

    public Dentist findById(Integer id){
        return dentistRepository.findById(id).orElseThrow(
                ()-> new NotFoundException("Not found")
        );
    }
}
