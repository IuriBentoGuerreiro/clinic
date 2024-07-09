package com.consultorio.odontologico.repository;

import com.consultorio.odontologico.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Integer> {
}
