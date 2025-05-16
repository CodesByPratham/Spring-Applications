package com.pratham.springBoot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication

public class Application {
    public static void main(String[] args) {

        /*
         * -- Inversion of Control (IoC) --
         * Inversion of Control (IoC) is a design principle used to invert the flow of control in a program.
         * Traditionally, your code is in control and creates the objects(beans) it needs.
         * With IoC, that control is "inverted", meaning the framework (like Spring) is in charge of creating and managing the objects.
         * Spring Boot uses IoC through a container called the Spring IoC Container. This container:
         * - Creates objects (beans)
         * - Manages their lifecycle
         * - Injects dependencies wherever needed
         *
         * -- Dependency Injection --
         * Dependency Injection is a design pattern where the dependencies of a class are "injected" from outside, rather than the class creating them itself.
         * A dependency is just an object that another object needs to function.
         *
         * Instead of a class creating its own dependencies, Spring Boot provides them (injects them)
         * Types of Dependency Injection in Spring:
         * - Constructor Injection (Recommended)
         * - Setter Injection
         * - Field Injection (Not recommended for testing/clean code)
         *
         * IoC is the bigger idea — giving control to the framework
         * DI is how IoC is done — by injecting dependencies instead of creating them manually
         */
        ApplicationContext context = SpringApplication.run(Application.class, args);

        Traveler pratham = context.getBean(Traveler.class);
        pratham.travel();
    }
}
