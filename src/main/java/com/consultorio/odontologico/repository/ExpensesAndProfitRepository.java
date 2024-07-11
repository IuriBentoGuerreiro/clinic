package com.consultorio.odontologico.repository;

import com.consultorio.odontologico.model.ExpensesAndProfit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpensesAndProfitRepository extends JpaRepository<ExpensesAndProfit, Integer> {
}
