package com.submitter.val.service;

import org.apache.commons.lang.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.submitter.val.domain.Submitter;

@Service
public class SubmitterValidationService {

	private static final Logger logger = LogManager.getLogger(SubmitterValidationService.class);

	@Autowired
	private RestTemplate restTemplate; //TODO To be used for external HIPAA validation

	public void validateSubmitterInfo(Submitter submitter) {

		logger.info("Submitter validation start: " + submitter.getCorrelationID());

		// Submitter ID is numeric and 9 digits long
		if (StringUtils.isEmpty(submitter.getSubmitterID())) {
			submitter.getErrorCode().add("Submitter ID is absent");
		} else if (!StringUtils.isNumeric(submitter.getSubmitterID())) {
			submitter.getErrorCode().add("Submitter ID is not numeric");
		} else if (submitter.getSubmitterID().length() != 9) {
			submitter.getErrorCode().add("Submitter ID length is not 9 digits");
		}

		logger.info("Patient validation end: " + submitter.getCorrelationID());

	}
	
	// Refer RT EVA and add spring scheduler code for enrollment check
}
