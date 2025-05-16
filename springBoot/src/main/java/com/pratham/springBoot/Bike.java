package com.pratham.springBoot;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class Bike implements Vehicle {

    // @Autowired // Field Injection (Not recommended for testing/clean code).
    private Engine engine;

    // Constructor Injection (Recommended)
    public Bike(Engine engine) {
        this.engine = engine;
    }

    // @Autowired // Setter Injection
    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    @Override
    public void drive() {
        engine.start();
        System.out.println("Bike is driving...");
    }
}
