package com.amit.patientscheduling.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.amit.patientscheduling.entities.Patient;

@Repository
public interface PatientRepository extends CrudRepository<Patient, Long> {

}
