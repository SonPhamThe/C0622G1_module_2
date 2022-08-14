package demo_haitt.demo_exercise2.model;

public class MotorBike extends Vehicle {
    private double wattage;

    public MotorBike(double wattage) {
        this.wattage = wattage;
    }

    public MotorBike(String licensePlates, String manufacturer, int yearOfManufacturer, String owner, double wattage) {
        super(licensePlates, manufacturer, yearOfManufacturer, owner);
        this.wattage = wattage;
    }

    public double getWattage() {
        return wattage;
    }

    public void setWattage(double wattage) {
        this.wattage = wattage;
    }

    @Override
    public String toString() {
        return "It is a motorbike has a " +
                "wattage = " + wattage + super.toString();
    }
}
