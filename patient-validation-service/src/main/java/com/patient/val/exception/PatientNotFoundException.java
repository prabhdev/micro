package com.patient.val.exception;

public class PatientNotFoundException extends RuntimeException {

	/**
	 * Runtime exception definition for PatientID not found
	 */
	private static final long serialVersionUID = 1L;

	public PatientNotFoundException(String id) {

		super(String.format("Patient with ID: %d not found", id));
	}

}
