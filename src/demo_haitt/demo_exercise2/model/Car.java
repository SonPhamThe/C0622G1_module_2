package demo_haitt.demo_exercise2.model;

public class Car extends Vehicle{
    private String vehicleType;
    private int numberSeat;

    public Car(String vehicleType, int numberSeat) {
        this.vehicleType = vehicleType;
        this.numberSeat = numberSeat;
    }

    public Car(String licensePlates, String manufacturer, int yearOfManufacturer, String owner, String vehicleType, int numberSeat) {
        super(licensePlates, manufacturer, yearOfManufacturer, owner);
        this.vehicleType = vehicleType;
        this.numberSeat = numberSeat;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public int getNumberSeat() {
        return numberSeat;
    }

    public void setNumberSeat(int numberSeat) {
        this.numberSeat = numberSeat;
    }

    @Override
    public String toString() {
        return "It is a Car has a " +
                "vehicleType = " + vehicleType+
                ", numberSeat = " + numberSeat + super.toString();
    }
}
