package org.pratham;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml")) {

            // Traveler traveler = (Traveler) context.getBean("traveler");

            Traveler traveler = context.getBean(Traveler.class);
            traveler.travel();
        }
    }
}
