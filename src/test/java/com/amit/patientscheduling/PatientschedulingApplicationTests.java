package com.amit.patientscheduling;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Date;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.amit.patientscheduling.entities.Appointment;
import com.amit.patientscheduling.entities.Doctor;
import com.amit.patientscheduling.entities.Insurance;
import com.amit.patientscheduling.entities.Patient;
import com.amit.patientscheduling.repos.AppointmentRepository;
import com.amit.patientscheduling.repos.DoctorRepository;
import com.amit.patientscheduling.repos.PatientRepository;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
class PatientschedulingApplicationTests {
	
	@Autowired
	DoctorRepository doctorRepository;
	
	@Autowired
	PatientRepository patientRepository;
	
	@Autowired
	AppointmentRepository appointmentRepository;

	@Test
	@Order(1)
	void testCreateDoctor() {
		
		Doctor doctor = new Doctor();
		doctor.setFirstName("John");
		doctor.setLastName("Smith");
		doctor.setSpeciality("All");
		doctorRepository.save(doctor);
	}
	
	@Test
	@Order(2)
	void testCreatePatient() {
		Patient patient = new Patient();
		patient.setFirstName("sonu");
		patient.setLastName("strain");
		patient.setPhone("123456");
		
		
		Insurance insurance = new Insurance();
		insurance.setProviderName("LIC");
		insurance.setCopay(1000d);
		
		
		patient.setInsurance(insurance);
		
		Doctor doctor= doctorRepository.findById(1L).get();
		
		patient.setDoctors(Arrays.asList(doctor));
		
		patientRepository.save(patient);
	}
	
	@Test
	@Order(3)
	void testCreateAppointment() {
		Appointment appointment = new Appointment();
		Timestamp appointmentTime = new Timestamp(new Date().getTime());
		appointment.setAppointmentTime(appointmentTime);
		appointment.setReason("problem");
		appointment.setStarted(true);
		appointment.setPatient(patientRepository.findById(1L).get());
		appointment.setDoctor(doctorRepository.findById(1L).get());
		appointmentRepository.save(appointment);
	}
	

}
