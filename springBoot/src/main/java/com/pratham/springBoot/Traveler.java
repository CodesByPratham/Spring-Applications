package com.pratham.springBoot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Traveler {

    /*
     * Spring resolves conflicts when multiple beans implement the same interface.
     * You have an interface Vehicle and two implementations: Car and Bike
     * Now, we try to inject like this:
     */
    @Autowired
    @Qualifier("car") // bean name (usually class name in lowercase)
    private Vehicle vehicle;


    /*
     * Ways to Resolve This
     * - Use @Primary(checkout Bike class): You can tell Spring which bean to prefer by marking one as primary
     * - Use @Qualifier(checkout this class): Spring uses the class name (camelCase) as the default bean name
     *
     * NOTE: If both are specified @Primary in Bike class and @Qualifier("car") in present class then @Qualifier is prioritized.
     */

    public void travel() {
        vehicle.drive();
    }
}
