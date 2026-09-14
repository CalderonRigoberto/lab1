package com.rigocalderon.lab1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@SpringBootApplication
public class Lab1Application {

	static void main(String[] args) {
		SpringApplication.run(Lab1Application.class, args);
	}

}
