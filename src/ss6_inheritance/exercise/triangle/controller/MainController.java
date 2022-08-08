package ss6_inheritance.exercise.triangle.controller;

import org.w3c.dom.ls.LSOutput;
import ss6_inheritance.exercise.triangle.model.Triangle;

import java.util.Arrays;
import java.util.Scanner;

public class MainController {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

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
                System.out.printf("Invalid input value\n" +
                        "Retype %s >=0", nameOfVariable);
            }

        } while (sideIsInvalid);
        return side;
    }

    public static void inputArray(Triangle[] arr) {
        Scanner scan = new Scanner(System.in);
        double side1 = inputSide("The side1 of shape");
        double side2 = inputSide("The side2 of shape");
        double side3 = inputSide("The side3 of shape");
        Triangle triangle = new Triangle(side1, side2, side3);
        arr[0] = triangle;
    }

}


