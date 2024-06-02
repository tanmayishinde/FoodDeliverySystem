package com.fooddelivery.apigatewayservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@ConfigurationProperties
public class ApigatewayServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApigatewayServiceApplication.class, args);
	}

}
