package demo_haitt.demo_exercise2.model;

public abstract class Vehicle {
    private String licensePlates;
    private String manufacturer;
    private int yearOfManufacturer;
    private String owner;

    public Vehicle() {
    }

    public Vehicle(String licensePlates, String manufacturer, int yearOfManufacturer, String owner) {
        this.licensePlates = licensePlates;
        this.manufacturer = manufacturer;
        this.yearOfManufacturer = yearOfManufacturer;
        this.owner = owner;
    }

    public String getLicensePlates() {
        return licensePlates;
    }

    public void setLicensePlates(String licensePlates) {
        this.licensePlates = licensePlates;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getYearOfManufacturer() {
        return yearOfManufacturer;
    }

    public void setYearOfManufacturer(int yearOfManufacturer) {
        this.yearOfManufacturer = yearOfManufacturer;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return ", licensePlates = " + licensePlates +
                ", manufacturer = " + manufacturer +
                ", yearOfManufacturer = " + yearOfManufacturer +
                ", owner = " + owner;
    }
}
