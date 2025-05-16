package com.pratham.staticWebApi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StaticWebApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(StaticWebApiApplication.class, args);
		System.out.println("Application running on http://localhost:8080/");
	}
}
