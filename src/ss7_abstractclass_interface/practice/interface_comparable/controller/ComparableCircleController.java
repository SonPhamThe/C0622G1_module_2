package ss7_abstractclass_interface.practice.interface_comparable.controller;

import ss7_abstractclass_interface.practice.interface_comparable.model.ComparableCircle;

import java.util.Arrays;

public class ComparableCircleController {
    public static void main(String[] args) {
        ComparableCircle[] circle = new ComparableCircle[3];
        circle[0] = new ComparableCircle(3.6);
        circle[1] = new ComparableCircle();
        circle[2] = new ComparableCircle(3.0, "white", false);

        System.out.println("Pre-sorted: ");

        for (ComparableCircle circles : circle) {
            System.out.println(circles);
        }

        Arrays.sort(circle);

        System.out.println("After-sorted: ");
        for (ComparableCircle circles : circle) {
            System.out.println(circles);
        }
    }
}
