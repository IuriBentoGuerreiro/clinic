package com.consultorio.odontologico.controller;

import com.consultorio.odontologico.service.ExpensesAndProfitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/profits")
public class ExpensesAndProfitController {

    @Autowired
    private ExpensesAndProfitService service;

    @GetMapping("/{idEquipment}")
    public BigDecimal getProfitByEquipment(Integer idEquipment){
        return service.getProfitByEquipment(idEquipment);
    }

    @GetMapping
    public String getAllExpense(){
        return service.getAllExpense();
    }
}
