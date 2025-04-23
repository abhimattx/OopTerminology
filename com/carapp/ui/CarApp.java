package com.carapp.ui;

import com.carapp.model.Car;
import com.carapp.model.Trip;
import com.carapp.model.Maintenance;
import com.carapp.service.CarService;
import com.carapp.util.InputValidator;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;
import java.text.DecimalFormat;

public class CarApp {
    private static final CarService carService = new CarService();
    private static final Scanner scanner = new Scanner(System.in);
    private static final DecimalFormat df = new DecimalFormat("#.##");
    private static final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    
    public static void main(String[] args) {
        boolean running = true;
        
        while (running) {
            displayMenu();
            int choice = InputValidator.getIntInput(scanner, "Enter your choice: ", 1, 7);
            
            switch (choice) {
                case 1:
                    addNewCar();
                    break;
                case 2:
                    recordNewTrip();
                    break;
                case 3:
                    recordMaintenance();
                    break;
                case 4:
                    viewCarDetails();
                    break;
                case 5:
                    viewTripHistory();
                    break;
                case 6:
                    viewMaintenanceHistory();
                    break;
                case 7:
                    running = false;
                    break;
            }
        }
        
        scanner.close();
        System.out.println("Thank you for using Car Management App!");
    }
    
    private static void displayMenu() {
        System.out.println("\n===== CAR MANAGEMENT SYSTEM =====");
        System.out.println("1. Add New Car");
        System.out.println("2. Record New Trip");
        System.out.println("3. Record Maintenance");
        System.out.println("4. View Car Details");
        System.out.println("5. View Trip History");
        System.out.println("6. View Maintenance History");
        System.out.println("7. Exit");
        System.out.println("================================");
    }
    
    private static void addNewCar() {
        System.out.println("\n-- Add New Car --");
        
        String make = InputValidator.getStringInput(scanner, "Enter car make: ");
        String model = InputValidator.getStringInput(scanner, "Enter car model: ");
        int year = InputValidator.getIntInput(scanner, "Enter car year: ", 1900, 2100);
        double odometer = InputValidator.getDoubleInput(scanner, "Enter current odometer reading: ", 0, 1000000);
        String fuelType = InputValidator.getStringInput(scanner, "Enter fuel type: ");
        double tankCapacity = InputValidator.getDoubleInput(scanner, "Enter tank capacity: ", 0, 200);
        
        Car car = new Car(make, model, year, odometer, fuelType, tankCapacity);
        carService.addCar(car);
        
        System.out.println("Car added successfully!");
    }
    
    private static void recordNewTrip() {
        if (carService.getAllCars().isEmpty()) {
            System.out.println("No cars available. Please add a car first.");
            return;
        }
        
        String carId = getCarIdentifier();
        Car car = carService.getCar(carId);
        
        if (car == null) {
            System.out.println("Car not found.");
            return;
        }
        
        System.out.println("\n-- Record New Trip for " + car.getMake() + " " + car.getModel() + " --");
        LocalDate date = getDateInput("Enter trip date (yyyy-MM-dd): ");
        double startOdo = InputValidator.getDoubleInput(scanner, "Enter starting odometer reading: ", 0, 1000000);
        double endOdo = InputValidator.getDoubleInput(scanner, "Enter ending odometer reading: ", startOdo, 1000000);
        double fuelUsed = InputValidator.getDoubleInput(scanner, "Enter fuel used (in liters): ", 0.1, 1000);
        double travelTime = InputValidator.getDoubleInput(scanner, "Enter travel time (in hours): ", 0.1, 100);
        
        scanner.nextLine(); // Consume any leftover newline
        String description = InputValidator.getStringInput(scanner, "Enter trip description: ");
        
        Trip trip = new Trip(date, startOdo, endOdo, fuelUsed, travelTime, description);
        carService.recordTrip(carId, trip);
        
        System.out.println("Trip recorded successfully!");
        System.out.println("Distance: " + df.format(trip.getDistance()) + " km");
        System.out.println("Average Speed: " + df.format(trip.getAverageSpeed()) + " km/h");
        System.out.println("Fuel Efficiency: " + df.format(trip.getFuelEfficiency()) + " km/L");
    }
    
    private static void recordMaintenance() {
        if (carService.getAllCars().isEmpty()) {
            System.out.println("No cars available. Please add a car first.");
            return;
        }
        
        String carId = getCarIdentifier();
        Car car = carService.getCar(carId);
        
        if (car == null) {
            System.out.println("Car not found.");
            return;
        }
        
        System.out.println("\n-- Record Maintenance for " + car.getMake() + " " + car.getModel() + " --");
        LocalDate date = getDateInput("Enter maintenance date (yyyy-MM-dd): ");
        String serviceType = InputValidator.getStringInput(scanner, "Enter service type: ");
        String description = InputValidator.getStringInput(scanner, "Enter description: ");
        double cost = InputValidator.getDoubleInput(scanner, "Enter cost: $", 0, 100000);
        double odometerReading = InputValidator.getDoubleInput(scanner, "Enter odometer reading: ", 0, 1000000);
        
        Maintenance maintenance = new Maintenance(date, serviceType, description, cost, odometerReading);
        carService.recordMaintenance(carId, maintenance);
        
        System.out.println("Maintenance record added successfully!");
    }
    
    private static void viewCarDetails() {
        if (carService.getAllCars().isEmpty()) {
            System.out.println("No cars available. Please add a car first.");
            return;
        }
        
        String carId = getCarIdentifier();
        Car car = carService.getCar(carId);
        
        if (car == null) {
            System.out.println("Car not found.");
            return;
        }
        
        System.out.println("\n-- Car Details --");
        System.out.println("Make: " + car.getMake());
        System.out.println("Model: " + car.getModel());
        System.out.println("Year: " + car.getYear());
        System.out.println("Current Odometer: " + df.format(car.getCurrentOdometer()) + " km");
        System.out.println("Fuel Type: " + car.getFuelType());
        System.out.println("Tank Capacity: " + car.getTankCapacity() + " liters");
        System.out.println("Classification: " + car.classifyCar());
        
        double avgEfficiency = car.getAverageEfficiency();
        if (avgEfficiency > 0) {
            System.out.println("Average Fuel Efficiency: " + df.format(avgEfficiency) + " km/L");
        } else {
            System.out.println("Average Fuel Efficiency: No trip data available");
        }
        
        System.out.println("Number of Trips: " + car.getTripHistory().size());
        System.out.println("Number of Maintenance Records: " + car.getMaintenanceHistory().size());
    }
    
    private static void viewTripHistory() {
        if (carService.getAllCars().isEmpty()) {
            System.out.println("No cars available. Please add a car first.");
            return;
        }
        
        String carId = getCarIdentifier();
        Car car = carService.getCar(carId);
        
        if (car == null) {
            System.out.println("Car not found.");
            return;
        }
        
        List<Trip> trips = car.getTripHistory();
        
        if (trips.isEmpty()) {
            System.out.println("\nNo trips recorded for this car.");
            return;
        }
        
        System.out.println("\n-- Trip History for " + car.getMake() + " " + car.getModel() + " --");
        int i = 1;
        for (Trip trip : trips) {
            System.out.println(i + ". " + trip);
            i++;
        }
        
        // Calculate and display totals
        double totalDistance = 0;
        double totalFuel = 0;
        
        for (Trip trip : trips) {
            totalDistance += trip.getDistance();
            totalFuel += trip.getFuelUsed();
        }
        
        System.out.println("\nTotal Distance: " + df.format(totalDistance) + " km");
        System.out.println("Total Fuel Used: " + df.format(totalFuel) + " L");
        System.out.println("Overall Efficiency: " + df.format(totalDistance/totalFuel) + " km/L");
    }
    
    private static void viewMaintenanceHistory() {
        if (carService.getAllCars().isEmpty()) {
            System.out.println("No cars available. Please add a car first.");
            return;
        }
        
        String carId = getCarIdentifier();
        Car car = carService.getCar(carId);
        
        if (car == null) {
            System.out.println("Car not found.");
            return;
        }
        
        List<Maintenance> records = car.getMaintenanceHistory();
        
        if (records.isEmpty()) {
            System.out.println("\nNo maintenance records for this car.");
            return;
        }
        
        System.out.println("\n-- Maintenance History for " + car.getMake() + " " + car.getModel() + " --");
        int i = 1;
        double totalCost = 0;
        
        for (Maintenance record : records) {
            System.out.println(i + ". " + record);
            totalCost += record.getCost();
            i++;
        }
        
        System.out.println("\nTotal Maintenance Cost: $" + df.format(totalCost));
    }
    
    private static String getCarIdentifier() {
        List<Car> cars = carService.getAllCars();
        
        System.out.println("\nAvailable Cars:");
        int i = 1;
        for (Car car : cars) {
            System.out.println(i + ". " + car.getMake() + " " + car.getModel() + " (" + car.getYear() + ")");
            i++;
        }
        
        int carIndex = InputValidator.getIntInput(scanner, "Select car: ", 1, cars.size()) - 1;
        Car selectedCar = cars.get(carIndex);
        return selectedCar.getMake() + "-" + selectedCar.getModel() + "-" + selectedCar.getYear();
    }
    
    private static LocalDate getDateInput(String prompt) {
        LocalDate date = null;
        boolean validInput = false;
        
        while (!validInput) {
            try {
                System.out.print(prompt);
                String input = scanner.nextLine();
                date = LocalDate.parse(input, dateFormatter);
                validInput = true;
            } catch (DateTimeParseException e) {
                System.out.println("Invalid date format. Please use yyyy-MM-dd format.");
            }
        }
        
        return date;
    }
}