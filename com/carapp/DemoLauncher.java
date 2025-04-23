package com.carapp;

import com.carapp.model.Car;
import com.carapp.model.Trip;
import com.carapp.model.Maintenance;
import com.carapp.ui.CarApp;

import java.time.LocalDate;

public class DemoLauncher {
    public static void main(String[] args) {
        // To start the main application normally, uncomment this line:
        // CarApp.main(args);

        // For demo purposes with sample data, use this:
        demoWithSampleData();
    }

    private static void demoWithSampleData() {
        // Create a car service
        com.carapp.service.CarService carService = new com.carapp.service.CarService();
        
        // Add a car
        Car car = new Car("Toyota", "Corolla", 2019, 12000, "Gasoline", 45);
        carService.addCar(car);
        
        // Add trips
        Trip trip1 = new Trip(
            LocalDate.of(2023, 1, 15),
            12000, 12350, 25, 4.5,
            "Weekend trip to the beach"
        );
        carService.recordTrip("Toyota-Corolla-2019", trip1);
        
        Trip trip2 = new Trip(
            LocalDate.of(2023, 2, 10),
            12350, 12800, 30, 5.2,
            "Visit to parents"
        );
        carService.recordTrip("Toyota-Corolla-2019", trip2);
        
        // Add maintenance records
        Maintenance maint1 = new Maintenance(
            LocalDate.of(2023, 3, 5),
            "Oil Change",
            "Regular oil change with filter replacement",
            65.99,
            13200
        );
        carService.recordMaintenance("Toyota-Corolla-2019", maint1);
        
        // Display car info
        Car retrievedCar = carService.getCar("Toyota-Corolla-2019");
        if (retrievedCar != null) {
            System.out.println("DEMO DATA LOADED");
            System.out.println("=================");
            System.out.println("Car: " + retrievedCar);
            System.out.println("Classification: " + retrievedCar.classifyCar());
            System.out.println("Average Efficiency: " + retrievedCar.getAverageEfficiency() + " km/L");
            
            System.out.println("\nTrip History:");
            for (Trip t : retrievedCar.getTripHistory()) {
                System.out.println("- " + t);
            }
            
            System.out.println("\nMaintenance History:");
            for (Maintenance m : retrievedCar.getMaintenanceHistory()) {
                System.out.println("- " + m);
            }
            
            System.out.println("\nStarting main application...");
            System.out.println("=================\n");
            
            // Launch the main app
            CarApp.main(new String[0]);
        }
    }
}