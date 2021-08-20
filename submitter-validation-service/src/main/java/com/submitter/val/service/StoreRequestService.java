package com.submitter.val.service;

import java.util.concurrent.CompletableFuture;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.submitter.val.domain.Submitter;

/**
 * Service class to store patient info by calling store-info microsrevice, which
 * takes care of saving info into a DB
 * 
 * @author Devanadha Prabhu
 *
 */

@Service
public class StoreRequestService {

	private static final Logger logger = LogManager.getLogger(StoreRequestService.class);

	@Autowired
	private RestTemplate restTemplate;

	@Async
	public CompletableFuture<Submitter> storeRequest(Submitter submitterInfo) throws InterruptedException {
		logger.info("Calling store service: " + submitterInfo);
		String url = String.format("https://api.github.com/users/%s", submitterInfo);
		Submitter result = restTemplate.postForObject("", submitterInfo, Submitter.class);
		return CompletableFuture.completedFuture(result);
	}

}
