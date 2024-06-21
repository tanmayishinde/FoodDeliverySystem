package com.fooddelivery.foodcatalogue_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDiscoveryClient

@ComponentScan("com.fooddelivery")
public class FoodcatalogueServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(FoodcatalogueServiceApplication.class, args);
	}

}
