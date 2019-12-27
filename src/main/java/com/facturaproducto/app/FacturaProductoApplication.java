package com.facturaproducto.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class FacturaProductoApplication {

	public static void main(String[] args) {
		SpringApplication.run(FacturaProductoApplication.class, args);
	}

}
