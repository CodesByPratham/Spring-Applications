package org.pratham;

public class Traveler {

    // Field injection
    private Vehicle vehicle;

    // Constructor injection
    public Traveler(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    // Setter injection
    /* public void setVehicle(Vehicle vehicle) {
         this.vehicle = vehicle;
     }*/

    public void travel() {
        vehicle.drive();
    }
}
