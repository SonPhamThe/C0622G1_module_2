package ss1_introduction.practice;


import java.util.Scanner;

public class UseOperator {
    public static void main(String[] args) {
        double width;
        double height;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter width: ");
        width = scanner.nextDouble();

        System.out.println("Enter height: ");
        height = scanner.nextDouble();

        double area = width * height;

        System.out.println("Area is: " + area);
    }
}
