package com.patient.val.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.patient.val.data.repo.PatientRepository;
import com.patient.val.domain.Patient;
import com.patient.val.exception.PatientNotFoundException;

/**
 * Service class to store patient info
 * 
 * @author Devanadha Prabhu
 *
 */

@Service
public class StorePatientService {

	private static final Logger logger = LogManager.getLogger(StorePatientService.class);

	@Autowired
	private PatientRepository patRepository;

	/**
	 * Retrieve patient details using the given patient ID
	 * 
	 * @param patientID - Lookup parameter
	 * @return Patient - Object to hold patient information
	 */
	public Patient getPatient(String patientID) {
		logger.info("In getPatient");
		return patRepository.findById(patientID).orElseThrow(() -> new PatientNotFoundException(patientID));
	}

	/**
	 * Store patient information
	 * 
	 * @param patient - Object holding patient information intended for db storage
	 */
	public void addPatient(Patient patient) {
		logger.info("In addPatient");
		patRepository.save(patient);
	}

}
