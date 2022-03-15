package com.amit.patientscheduling.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.amit.patientscheduling.entities.Doctor;

@Repository
public interface DoctorRepository extends CrudRepository<Doctor, Long> {

}
