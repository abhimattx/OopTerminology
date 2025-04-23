package com.carapp.model;

import com.carapp.model.Trip;
import com.carapp.model.Maintenance;
import com.carapp.service.CarService;
import com.carapp.ui.*;

import java.time.LocalDate;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Car {
    private String model;
    private String make;
    private int year;
    private double currentOdometer;
    private String fuelType;
    private double tankCapacity;
    private List<Trip> tripHistory;
    private List<Maintenance> maintenanceHistory;
    
    public Car(String make, String model, int year, double currentOdometer, String fuelType, double tankCapacity) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.currentOdometer = currentOdometer;
        this.fuelType = fuelType;
        this.tankCapacity = tankCapacity;
        this.tripHistory = new ArrayList<>();
        this.maintenanceHistory = new ArrayList<>();
    }
    
    // Getters and setters
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getCurrentOdometer() {
        return currentOdometer;
    }

    public void setCurrentOdometer(double currentOdometer) {
        this.currentOdometer = currentOdometer;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public double getTankCapacity() {
        return tankCapacity;
    }

    public void setTankCapacity(double tankCapacity) {
        this.tankCapacity = tankCapacity;
    }
    
    public void addTrip(Trip trip) {
        tripHistory.add(trip);
        currentOdometer += trip.getDistance();
    }
    
    public void addMaintenance(Maintenance maintenance) {
        maintenanceHistory.add(maintenance);
    }
    
    public double getAverageEfficiency() {
        if (tripHistory.isEmpty()) {
            return 0;
        }
        
        double totalFuel = 0;
        double totalDistance = 0;
        
        for (Trip trip : tripHistory) {
            totalFuel += trip.getFuelUsed();
            totalDistance += trip.getDistance();
        }
        
        return totalDistance / totalFuel;
    }
    
    public String classifyCar() {
        int currentYear = Year.now().getValue();
        double age = currentYear - year;
        
        if (age >= 0 && age <= 1.0) {
            return "New car, enjoy it!";
        } else if (age > 1.0 && age <= 3.0) {
            return "Semi-used car, how is it going?";
        } else if (age > 3.0 && age <= 5.0) {
            return "Used car, it's probably a good time to start looking for a new one.";
        } else {
            return "Old car, please change it!";
        }
    }
    
    public List<Trip> getTripHistory() {
        return new ArrayList<>(tripHistory);
    }
    
    public List<Maintenance> getMaintenanceHistory() {
        return new ArrayList<>(maintenanceHistory);
    }
    
    @Override
    public String toString() {
        return make + " " + model + " (" + year + ") - Current odometer: " + 
               String.format("%.1f", currentOdometer) + " km";
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return year == car.year && 
               Objects.equals(make, car.make) && 
               Objects.equals(model, car.model);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(make, model, year);
    }
}