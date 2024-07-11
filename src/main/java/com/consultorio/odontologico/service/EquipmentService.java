package com.consultorio.odontologico.service;

import com.consultorio.odontologico.dto.equipment.EquipmentRequest;
import com.consultorio.odontologico.dto.equipment.EquipmentResponse;
import com.consultorio.odontologico.model.Equipment;
import com.consultorio.odontologico.repository.EquipmentRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;

@Service
public class EquipmentService {

    @Autowired
    private EquipmentRepository equipmentRepository;

    public EquipmentResponse save(EquipmentRequest equipmentRequest){
        return EquipmentResponse.convert(equipmentRepository.save(Equipment.convert(equipmentRequest)));
    }

    public List<EquipmentResponse> findAll(){
        return equipmentRepository.findAll().stream()
                .map(EquipmentResponse::convert).toList();
    }

    public Equipment findById(Integer id){
        return equipmentRepository.findById(id).orElseThrow(
                ()-> new NotFoundException("Not found")
        );
    }

    public Equipment update(Integer id, EquipmentRequest equipmentRequest){
        var equipmentSave = findById(id);
        BeanUtils.copyProperties(equipmentRequest, equipmentSave, "id");
        return equipmentRepository.save(equipmentSave);
    }
    public void deleteById(Integer id){
        equipmentRepository.deleteById(id);
    }

    public List<Equipment> findAllById(List<Integer> id){
        return equipmentRepository.findAllById(id);
    }
}