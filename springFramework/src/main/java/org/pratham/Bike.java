package org.pratham;

public class Bike implements Vehicle {

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
        System.out.println("Bike is driving...");
    }
}
