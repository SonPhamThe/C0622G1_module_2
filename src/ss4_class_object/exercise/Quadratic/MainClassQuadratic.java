package ss4_class_object.exercise.Quadratic;


import java.util.Scanner;

public class MainClassQuadratic {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter coefficient a:");
        double a = Double.parseDouble(scanner.nextLine());
        System.out.print("Enter coefficient b:");
        double b = Double.parseDouble(scanner.nextLine());
        System.out.print("Enter coefficient c:");
        double c = Double.parseDouble(scanner.nextLine());
         ClassQuadratic classQuadratic = new ClassQuadratic(a, b, c);
        System.out.println("The quadratic have coefficient: " + classQuadratic.display());
        if(a!=0) {
            if (classQuadratic.getDiscriminant() < 0) {
                System.out.println("The equation has no roots");
            } else if (classQuadratic.getDiscriminant() == 0) {
                System.out.println("The equation has dual roots is: " + classQuadratic.getRoot1());
            } else {
                System.out.println("The equation has two distinguish root are: " + classQuadratic.getRoot1() + " and " + classQuadratic.getRoot2());
            }
        } else {
            System.out.println("The equation has single roots: "+classQuadratic.getSingleEquation());
        }
    }
}
