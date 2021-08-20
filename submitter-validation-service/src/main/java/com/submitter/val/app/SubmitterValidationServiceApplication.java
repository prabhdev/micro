package com.submitter.val.app;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class SubmitterValidationServiceApplication {

	@Value("$client.timeout")
	private int timeout;

	@Bean
	@LoadBalanced
	public RestTemplate getRestTemplate() {

		HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
		requestFactory.setConnectTimeout(timeout);
		return new RestTemplate(requestFactory);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SubmitterValidationServiceApplication.class, args);
	}

}
