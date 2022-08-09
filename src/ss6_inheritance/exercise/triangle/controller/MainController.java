package ss6_inheritance.exercise.triangle.controller;

import ss6_inheritance.exercise.triangle.model.Triangle;

import java.util.Arrays;
import java.util.Scanner;

public class MainController {
    public static void main(String[] args) {
        Triangle[] array = new Triangle[3];
        inputArray(array);
        System.out.println(Arrays.toString(array));
    }

    public static int inputSide(String nameOfVariable) {
        Scanner scanner = new Scanner(System.in);

        int side;
        boolean sideIsInvalid;

        System.out.print("Enter " + nameOfVariable);
        do {
            side = Integer.parseInt(scanner.nextLine());
            sideIsInvalid = side < 0;

            if (sideIsInvalid) {
                System.out.printf("Invalid input value\n" + "Retype %s >=0", nameOfVariable);
            }
        } while (sideIsInvalid);
        return side;
    }


    public static void inputArray(Triangle[] arr) {
        boolean sieIsInvalid1;
        double side1;
        double side2;
        double side3;
        do {
            side1 = inputSide("The side1 of shape");
            side2 = inputSide("The side2 of shape");
            side3 = inputSide("The side3 of shape");
            sieIsInvalid1 = side1 + side2 < side3 || side1 + side3 < side2 || side2 + side3 < side1;
            if (sieIsInvalid1) {
                System.out.print("Side1, side2 and side3 no side in a shape, please enter again\n");
            }
        } while (sieIsInvalid1);
        Triangle triangle = new Triangle(side1, side2, side3);
        arr[0] = triangle;
    }

}


