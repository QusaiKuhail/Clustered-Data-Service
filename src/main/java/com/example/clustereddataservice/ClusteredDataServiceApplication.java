package com.example.clustereddataservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.example.clustereddataservice.repository")
public class ClusteredDataServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClusteredDataServiceApplication.class, args);
	}

}
