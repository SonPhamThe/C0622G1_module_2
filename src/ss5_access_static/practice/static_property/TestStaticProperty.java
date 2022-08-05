package ss5_access_static.practice.static_property;

public class TestStaticProperty {
    public static void main(String[] args) {
        Car car1 = new Car("Mercedes", "automotive 3");
        System.out.println(Car.numberOffCars);
        Car car2 = new Car("Lexus", "automotive 2");
        System.out.println(Car.numberOffCars);
    }
}
