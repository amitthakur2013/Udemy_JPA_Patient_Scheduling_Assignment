package com.amit.patientscheduling.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.amit.patientscheduling.entities.Appointment;

@Repository
public interface AppointmentRepository extends CrudRepository<Appointment, Long> {

}
