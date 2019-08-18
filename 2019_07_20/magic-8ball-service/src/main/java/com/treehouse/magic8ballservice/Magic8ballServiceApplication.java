package com.treehouse.magic8ballservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class Magic8ballServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(Magic8ballServiceApplication.class, args);
	}

}
