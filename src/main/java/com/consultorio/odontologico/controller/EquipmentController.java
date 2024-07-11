package com.consultorio.odontologico.controller;

import com.consultorio.odontologico.dto.equipment.EquipmentRequest;
import com.consultorio.odontologico.dto.equipment.EquipmentResponse;
import com.consultorio.odontologico.service.EquipmentService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "equipment")
@RestController
@RequestMapping("/equipment")
public class EquipmentController {

    @Autowired
    private EquipmentService equipmentService;

    @PostMapping
    public EquipmentResponse save(@RequestBody EquipmentRequest equipmentRequest){
        return equipmentService.save(equipmentRequest);
    }

    @GetMapping
    public List<EquipmentResponse> findAll(){
        return equipmentService.findAll();
    }

    @GetMapping("/{id}")
    public EquipmentResponse findById(@PathVariable Integer id){
        return EquipmentResponse.convert(equipmentService.findById(id));
    }

    @PutMapping("/{id}")
    public EquipmentResponse update(@PathVariable Integer id, @RequestBody EquipmentRequest equipmentRequest){
        return EquipmentResponse.convert(equipmentService.update(id, equipmentRequest));
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id){
        equipmentService.deleteById(id);
    }
}