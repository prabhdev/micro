package com.submitter.val.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.submitter.val.domain.Submitter;
import com.submitter.val.service.StoreRequestService;
import com.submitter.val.service.SubmitterValidationService;

@RestController
@RequestMapping("/api/submitter")
public class SubmitterValidationServiceController {

	

		@Autowired
		private StoreRequestService storeService;
		
		@Autowired
		private SubmitterValidationService submitterInfoValidateService;
		
		// Add a functionality to add a submitter:
		// Use response entity to standardize the response
		// Add a controller adviser for global exception handling

		@PostMapping("/validateAndStore")
		public ResponseEntity<Void> validateAndStoreSubmitterInfo(@RequestBody Submitter submitterInfo) throws InterruptedException {

			// Add role evaluator to check for roles
			
			// Call service to validate submitter info
			submitterInfoValidateService.validateSubmitterInfo(submitterInfo);

			// Call store service to store the request
			storeService.storeRequest(submitterInfo);

			return ResponseEntity.accepted().build();

		}

	

}
