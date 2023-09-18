package com.klagan.price.text;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {
		"com.klagan.price.text.presentation.mappers",
		"com.klagan.price.text.application.service",
		"com.klagan.price.text.infrastructure.persistence",
		"com.klagan.price.text",
})
@EnableR2dbcRepositories
public class PriceTextApplication {

	public static void main(String[] args) {
		SpringApplication.run(PriceTextApplication.class, args);
	}

}
