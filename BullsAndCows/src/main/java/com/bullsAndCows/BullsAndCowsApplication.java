package com.bullsAndCows;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = { "com.bullsAndCows" })
public class BullsAndCowsApplication {
	public static void main(String[] args) {
		SpringApplication.run(BullsAndCowsApplication.class, args);
	}

}
