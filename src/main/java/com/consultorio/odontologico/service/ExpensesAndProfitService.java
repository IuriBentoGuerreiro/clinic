package com.consultorio.odontologico.service;

import com.consultorio.odontologico.model.ExpensesAndProfit;
import com.consultorio.odontologico.repository.ExpensesAndProfitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpensesAndProfitService {

    @Autowired
    private ExpensesAndProfitRepository expensesAndProfitRepository;

    public List<ExpensesAndProfit> findAllById(List<Integer> id){
        return expensesAndProfitRepository.findAllById(id);
    }
}
