package ss8_cleancode_refactoring.practice.separation_method.model;

public class Cylinder {
    public static double getVolume(int radius, int height) {
        double area = getArea(radius);
        double perimeter = getPerimeter(radius);
        double getVolume = perimeter * height + 2 * area;
        return getVolume;
    }

    public static double getArea(int radius) {
        return radius * radius * Math.PI;
    }

    public static double getPerimeter(int radius) {
        return 2 * radius * Math.PI;
    }
}
