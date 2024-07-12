package com.consultorio.odontologico.service;

import com.consultorio.odontologico.dto.dentist.DentistRequest;
import com.consultorio.odontologico.dto.dentist.DentistResponse;
import com.consultorio.odontologico.model.Dentist;
import com.consultorio.odontologico.repository.DentistRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;

@Service
public class DentistService {

    @Autowired
    private DentistRepository dentistRepository;

    public DentistResponse save(DentistRequest dentistRequest){
        return DentistResponse.convert(dentistRepository.save(Dentist.convert(dentistRequest)));
    }

    public List<DentistResponse> findAll(){
        return dentistRepository.findAll().stream()
                .map(DentistResponse::convert).toList();
    }

    public Dentist findById(Integer id){
        return dentistRepository.findById(id).orElseThrow(
                ()-> new NotFoundException("Not found")
        );
    }

    public Dentist update(Integer id, DentistRequest dentistRequest){
        var dentistSave = findById(id);
        BeanUtils.copyProperties(dentistRequest, dentistSave, "id");
        return dentistRepository.save(dentistSave);
    }

    public void deleteById(Integer id){
        dentistRepository.deleteById(id);
    }
}
