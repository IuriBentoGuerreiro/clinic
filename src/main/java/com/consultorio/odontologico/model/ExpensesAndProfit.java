package com.consultorio.odontologico.model;

import com.consultorio.odontologico.dto.profit.ExpensesAndProfitRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Table(name = "expenses_and_profits")
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ExpensesAndProfit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "date")
    private LocalDate date;
    @Column(name = "type")
    private String type;
    @Column(name = "description")
    private String description;

    private BigDecimal profit;

    @ManyToOne
    @JoinColumn(name = "appointment_id")
    private Appointment appointment;
    @ManyToOne
    @JoinColumn(name = "equipment_id")
    private Equipment equipment;

    public ExpensesAndProfit(Integer id){
        this.id = id;
    }

    public static ExpensesAndProfit convert(ExpensesAndProfitRequest expensesAndProfitsRequest){
        return ExpensesAndProfit.builder()
                .appointment(new Appointment(expensesAndProfitsRequest.getAppointmentId()))
                .equipment(new Equipment(expensesAndProfitsRequest.getEquipmentId()))
                .build();
    }
}