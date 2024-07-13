package com.educacionit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.educacionit", "com.educacionit.controller"})
public class DesafioIntegradorFinalApplication {

	public static void main(String[] args) {
		SpringApplication.run(DesafioIntegradorFinalApplication.class, args);
	}
}
