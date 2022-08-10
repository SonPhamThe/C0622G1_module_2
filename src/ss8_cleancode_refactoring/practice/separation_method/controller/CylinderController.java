package ss8_cleancode_refactoring.practice.separation_method.controller;

import ss8_cleancode_refactoring.practice.separation_method.model.Cylinder;

public class CylinderController {
    public static void main(String[] args) {
        int radius = 3;
        int height = 5;
        double result = Cylinder.getVolume(radius, height);
        double result1 = Cylinder.getArea(radius);
        double result2 = Cylinder.getPerimeter(radius);

        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result);
    }
}
