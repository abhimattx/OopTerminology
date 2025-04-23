package com.carapp.service;

import com.carapp.model.Car;
import com.carapp.model.Maintenance;
import com.carapp.model.Trip;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CarService {
    private Map<String, Car> cars = new HashMap<>();
    
    public void addCar(Car car) {
        String identifier = car.getMake() + "-" + car.getModel() + "-" + car.getYear();
        cars.put(identifier, car);
    }
    
    public Car getCar(String identifier) {
        return cars.get(identifier);
    }
    
    public List<Car> getAllCars() {
        return new ArrayList<>(cars.values());
    }
    
    public void recordTrip(String carId, Trip trip) {
        Car car = cars.get(carId);
        if (car != null) {
            car.addTrip(trip);
        }
    }
    
    public void recordMaintenance(String carId, Maintenance maintenance) {
        Car car = cars.get(carId);
        if (car != null) {
            car.addMaintenance(maintenance);
        }
    }
    
    public double calculateFuelCost(Trip trip, double fuelPrice) {
        return trip.getFuelUsed() * fuelPrice;
    }
    
    public List<Maintenance> getMaintenancesDue(String carId) {
        // Implementation to check which maintenance services are due
        // based on mileage and last service dates
        return new ArrayList<>();
    }
    
    public double getLifetimeMpg(String carId) {
        Car car = cars.get(carId);
        if (car != null) {
            return car.getAverageEfficiency();
        }
        return 0;
    }
}