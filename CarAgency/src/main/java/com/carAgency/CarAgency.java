package com.carAgency;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = { "com.bullsAndCows" })
public class CarAgency {
	public static void main(String[] args) {
		SpringApplication.run(CarAgency.class, args);
	}

}
