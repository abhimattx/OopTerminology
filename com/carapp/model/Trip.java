package com.carapp.model;

import java.time.LocalDate;

public class Trip {
    private LocalDate date;
    private double startOdometer;
    private double endOdometer;
    private double fuelUsed;
    private double travelTime;
    private String description;
    
    public Trip(LocalDate date, double startOdometer, double endOdometer, 
                double fuelUsed, double travelTime, String description) {
        this.date = date;
        this.startOdometer = startOdometer;
        this.endOdometer = endOdometer;
        this.fuelUsed = fuelUsed;
        this.travelTime = travelTime;
        this.description = description;
    }
    
    // Getters and setters
    public LocalDate getDate() {
        return date;
    }
    
    public double getStartOdometer() {
        return startOdometer;
    }
    
    public double getEndOdometer() {
        return endOdometer;
    }
    
    public double getTravelTime() {
        return travelTime;
    }
    
    public String getDescription() {
        return description;
    }
    
    public double getDistance() {
        return endOdometer - startOdometer;
    }
    
    public double getAverageSpeed() {
        return travelTime > 0 ? getDistance() / travelTime : 0;
    }
    
    public double getFuelEfficiency() {
        return fuelUsed > 0 ? getDistance() / (fuelUsed / 100) : 0;
    }
    
    public double getFuelUsed() {
        // Return the fuel used field directly
        return fuelUsed;
    }
    
    @Override
    public String toString() {
        return "Trip on " + date + ", Distance: " + getDistance() + 
               " km, Fuel Used: " + fuelUsed + " L, Avg Speed: " + 
               String.format("%.1f", getAverageSpeed()) + " km/h";
    }
}