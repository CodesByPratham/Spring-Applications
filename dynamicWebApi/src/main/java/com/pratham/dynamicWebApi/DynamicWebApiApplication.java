package com.pratham.dynamicWebApi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DynamicWebApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(DynamicWebApiApplication.class, args);
		System.out.println("Application running on http://localhost:8080/");
	}
}
