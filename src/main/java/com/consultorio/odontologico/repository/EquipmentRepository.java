package com.consultorio.odontologico.repository;

import com.consultorio.odontologico.model.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EquipmentRepository extends JpaRepository<Equipment, Integer> {
}
