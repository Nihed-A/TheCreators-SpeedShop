package com.example.pidevthecreators;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class PideVtheCreatorsApplication {

	public static void main(String[] args) {
		SpringApplication.run(PideVtheCreatorsApplication.class, args);
	}

}
