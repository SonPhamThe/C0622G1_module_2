package demo_haitt.demo_exercise2.model;

public class Truck extends Vehicle {
    private double tonnage;

    public Truck(double tonnage) {
        this.tonnage = tonnage;
    }

    public Truck(String licensePlates, String manufacturer, int yearOfManufacturer, String owner, double tonnage) {
        super(licensePlates, manufacturer, yearOfManufacturer, owner);
        this.tonnage = tonnage;
    }

    public double getTonnage() {
        return tonnage;
    }

    public void setTonnage(double tonnage) {
        this.tonnage = tonnage;
    }

    @Override
    public String toString() {
        return "It is a truck has a " +
                "tonnage = " + tonnage + super.toString();
    }
}
