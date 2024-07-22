package com.consultorio.odontologico.controller;

import com.consultorio.odontologico.service.ExpensesAndProfitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/profits")
public class ExpensesAndProfitController {

    @Autowired
    private ExpensesAndProfitService service;

    @GetMapping("/expenses")
    public String getAllExpense(){
        return service.getAllExpense();
    }

    @GetMapping("/cost")
    public String getAllProfit(){
        return service.getAllProfit();
    }

    @GetMapping("/expensesAndProfits")
    public String getAllExpensesProfit(){
        return service.getAllExpensesProfit();
    }
}
