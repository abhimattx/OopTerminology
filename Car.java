import java.util.Scanner;

public class Car {
    private int year;
    private double startKm;
    private double endKm;
    private double fuelConsumption;
    private double travelTime;

    public Car(String model, int year, double startKm, double endKm, double fuelConsumption, double travelTime) {
        this.year = year;
        this.startKm = startKm;
        this.endKm = endKm;
        this.fuelConsumption = fuelConsumption;
        this.travelTime = travelTime;
    }

    public double getTripLength() {
        return endKm - startKm;
    }

    public double getSpeed() {
        return getTripLength() / travelTime;
    }

    public double getFuelEfficiency() {
        double tripDistance = getTripLength();
        return tripDistance / (fuelConsumption / 100);
    }

    public String classifyCar() {
        double age = 2022 - year;
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

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter car model: ");
        String model = scanner.nextLine();

        System.out.print("Enter car year: ");
        int year = scanner.nextInt();

        System.out.print("Enter start kilometers: ");
        double startKm = scanner.nextDouble();

        System.out.print("Enter end kilometers: ");
        double endKm = scanner.nextDouble();

        System.out.print("Enter fuel consumption (liters): ");
        double fuelConsumption = scanner.nextDouble();

        System.out.print("Enter travel time (hours): ");
        double travelTime = scanner.nextDouble();

        Car car = new Car(model, year, startKm, endKm, fuelConsumption, travelTime);

        System.out.println("Trip Length: " + car.getTripLength() + " km");
        System.out.println("Average Speed: " + car.getSpeed() + " km/h");
        System.out.println("Fuel Efficiency: " + car.getFuelEfficiency() + " L/100km");
        System.out.println("Car Classification: " + car.classifyCar());

        scanner.close();
    }
}
