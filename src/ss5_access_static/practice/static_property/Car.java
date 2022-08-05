package ss5_access_static.practice.static_property;

public class Car {
    private String name;
    private String engine;

    public static int numberOffCars;

    public Car(String name, String engine) {
        this.name = name;
        this.engine = engine;
        numberOffCars++;
    }
}
