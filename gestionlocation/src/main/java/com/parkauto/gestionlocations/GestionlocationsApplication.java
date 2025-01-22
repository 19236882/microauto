package com.parkauto.gestionlocations;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class GestionlocationsApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestionlocationsApplication.class, args);
	}

}
