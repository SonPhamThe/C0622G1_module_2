package ss15_debug.exercise.checked_sideoftriangle;

import ss6_inheritance.exercise.triangle.model.Triangle;

import java.util.Scanner;

public class CheckSIdeOfTriangle {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        CheckSIdeOfTriangle check = new CheckSIdeOfTriangle();

        while (true) {
            try {
                System.out.println("Enter side of first");
                double sideOne = Double.parseDouble(scan.nextLine());
                System.out.println("Enter side of second");
                double sideTwo = Double.parseDouble(scan.nextLine());
                System.out.println("Enter side of third");
                double sideThree = Double.parseDouble(scan.nextLine());
                try {
                    check.checkTriangle(sideOne, sideTwo, sideThree);
                } catch (TriangleException e) {
                    System.out.println(e.getMessage());
                }
            } catch (NumberFormatException e) {
                System.out.println("It's a invalid");
            }
        }
    }

    public void checkTriangle(double sideOne, double sideTwo, double sideThree) throws TriangleException {
        if (sideOne + sideTwo <= sideThree || sideOne + sideThree <= sideTwo || sideTwo + sideThree <= sideOne) {
            throw new TriangleException("Not the side of the triangle");
        } else {
            System.out.println("Is the side of the triangle");
        }
    }
}
