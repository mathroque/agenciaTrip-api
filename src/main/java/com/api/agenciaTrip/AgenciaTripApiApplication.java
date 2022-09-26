package com.api.agenciaTrip;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class AgenciaTripApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(AgenciaTripApiApplication.class, args);
	}

}
