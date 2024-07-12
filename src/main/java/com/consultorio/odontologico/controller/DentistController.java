package com.consultorio.odontologico.controller;

import com.consultorio.odontologico.dto.dentist.DentistRequest;
import com.consultorio.odontologico.dto.dentist.DentistResponse;
import com.consultorio.odontologico.service.DentistService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Dentist")
@RestController
@RequestMapping("/dentist")
public class DentistController {

    @Autowired
    private DentistService dentistService;

    @PostMapping
    public DentistResponse save(@RequestBody DentistRequest dentistRequest){
        return dentistService.save(dentistRequest);
    }

    @GetMapping
    public List<DentistResponse> findAll(){
        return dentistService.findAll();
    }

    @GetMapping("/{id}")
    public DentistResponse findById(@PathVariable Integer id){
        return DentistResponse.convert(dentistService.findById(id));
    }

    @PutMapping("/{id}")
    public DentistResponse update(@PathVariable Integer id, @RequestBody DentistRequest dentistRequest){
        return DentistResponse.convert(dentistService.update(id, dentistRequest));
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id){
        dentistService.deleteById(id);
    }
}