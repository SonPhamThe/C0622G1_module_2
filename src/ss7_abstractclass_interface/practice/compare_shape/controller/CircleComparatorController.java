package ss7_abstractclass_interface.practice.compare_shape.controller;

import ss6_inheritance.practice.geometric.model.Circle;
import ss7_abstractclass_interface.practice.compare_shape.model.CircleComparator;
import ss7_abstractclass_interface.practice.interface_comparable.model.ComparableCircle;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class CircleComparatorController {
    public static void main(String[] args) {
        Circle[] circle = new Circle[3];
        circle[0] = new Circle(3.5);
        circle[1] = new Circle();
        circle[2] = new Circle(2.5, "red", true);
        System.out.println("Pre-sorted: ");
        for (Circle circles : circle) {
            System.out.println(circles);
        }

        Comparator<Circle> circleComparator = new CircleComparator();
        Arrays.sort(circle, circleComparator);

        System.out.println("After-sorted: ");
        for (Circle circles : circle) {
            System.out.println(circles);
        }
    }
}
