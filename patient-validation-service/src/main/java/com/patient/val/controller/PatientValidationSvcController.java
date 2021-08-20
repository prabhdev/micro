package com.patient.val.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.patient.val.domain.Patient;
import com.patient.val.domain.Response;
import com.patient.val.service.PatientValidationService;
import com.patient.val.service.StorePatientService;

/**
 * APIs to handle patient information
 * 
 * @author Devanadha Prabhu
 *
 */

@RestController
@RequestMapping("/api/patient")
public class PatientValidationSvcController {

	@Autowired
	private StorePatientService storeService;

	@Autowired
	private PatientValidationService patInfoValidateService;

	/**
	 * Validates patient information and returns a response containing error codes
	 * 
	 * @param patient - Contains patient info to be validated
	 * @return response - Validation codes to be interpreted by the caller
	 */
	@PostMapping(value = "/validate", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Response> validatePatientInfo(@RequestBody Patient patient) {

		Response response;

		if (patient == null) {
			response = new Response();
			response.getValidationCodes().add("PAT_ERR_00");
			return ResponseEntity.ok(response);
		}
		// Call service to validate patient info
		response = patInfoValidateService.validatePatientInfo(patient);

		return ResponseEntity.ok(response);

	}

	@PostMapping("/store")
	public ResponseEntity<String> storePatientInfo(@RequestBody Patient patient) throws InterruptedException {

		// Call store service to store the request
		storeService.addPatient(patient);

		return ResponseEntity.accepted().build();

	}

	@GetMapping(value = "/{id}", produces = "application/json")
	public ResponseEntity<Patient> getPatientInfo(@PathVariable("id") String id) throws InterruptedException {

		// Call service to obtain patient information
		Patient patient = storeService.getPatient(id);

		return ResponseEntity.ok(patient);

	}

}