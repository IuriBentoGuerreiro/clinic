package com.consultorio.odontologico.service;

import com.consultorio.odontologico.model.Equipment;
import com.consultorio.odontologico.repository.EquipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;

@Service
public class EquipmentService {

    @Autowired
    private EquipmentRepository equipmentRepository;

    public List<Equipment> findAllById(List<Integer> id){
        return equipmentRepository.findAllById(id);
    }
}
