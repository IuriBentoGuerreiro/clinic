package com.consultorio.odontologico.repository;

import com.consultorio.odontologico.model.Dentist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DentistRepository extends JpaRepository<Dentist, Integer> {
}
