package com.example.ny.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"controller", "repository", "service"})
public class NyApplication {

	public static void main(String[] args) {
		SpringApplication.run(NyApplication.class, args);
	}

}