package com.patient.val.app;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class PatientValidationSvcApp {

	@Value("${client.timeout}")
	private String timeout;

	@Bean
	@LoadBalanced
	public RestTemplate getRestTemplate() {

		HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
		requestFactory.setConnectTimeout(Integer.valueOf(timeout));
		return new RestTemplate(requestFactory);
	}

	public static void main(String[] args) {
		SpringApplication.run(PatientValidationSvcApp.class, args);
	}

}
