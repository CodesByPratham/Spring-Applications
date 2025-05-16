package org.pratham;

public class Car implements Vehicle {

    private Engine engine;

    public Engine getEngine() {
        return engine;
    }
    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    @Override
    public void drive() {
        engine.start();
        System.out.println("Car is driving...");
    }
}
