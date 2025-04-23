package com.carapp.model;

import java.time.LocalDate;

public class Maintenance {
    private LocalDate date;
    private String serviceType;
    private String description;
    private double cost;
    private double odometerReading;
    
    public Maintenance(LocalDate date, String serviceType, String description, 
                      double cost, double odometerReading) {
        this.date = date;
        this.serviceType = serviceType;
        this.description = description;
        this.cost = cost;
        this.odometerReading = odometerReading;
    }
    
    // Getters and setters
    public LocalDate getDate() {
        return date;
    }
    
    public String getServiceType() {
        return serviceType;
    }
    
    public String getDescription() {
        return description;
    }
    
    public double getCost() {
        return cost;
    }
    
    public double getOdometerReading() {
        return odometerReading;
    }
    
    @Override
    public String toString() {
        return serviceType + " on " + date + " at " + odometerReading + 
               " km, Cost: $" + String.format("%.2f", cost) + 
               (description != null && !description.isEmpty() ? " - " + description : "");
    }
}