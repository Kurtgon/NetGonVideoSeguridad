package com.jacaranda;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@EntityScan
@SpringBootApplication(scanBasePackages = {"com.jacaranda.controller", "com.jacaranda.services"})
public class NetGonVideoApplication {

	public static void main(String[] args) {
		SpringApplication.run(NetGonVideoApplication.class, args);
	}

}
