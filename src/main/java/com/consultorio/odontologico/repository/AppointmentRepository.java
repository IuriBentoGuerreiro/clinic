package com.consultorio.odontologico.repository;

import com.consultorio.odontologico.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {
}
