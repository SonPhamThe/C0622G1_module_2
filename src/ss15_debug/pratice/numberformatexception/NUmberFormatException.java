package ss15_debug.pratice.numberformatexception;

import java.util.Scanner;

public class NUmberFormatException {
    public static void main(String[] args) {
        NUmberFormatException number = new NUmberFormatException();
        number.calculate();
    }

    public void calculate() {
        Scanner scan = new Scanner(System.in);

        int x;
        int y;

        while (true) {
            try {
                System.out.println("Enter x");
                x = Integer.parseInt(scan.nextLine());
                System.out.println("Enter y");
                y = Integer.parseInt(scan.nextLine());
                int a = x + y;
                int b = x * y;
                int c = x - y;
                int d = x / y;

                System.out.println("Total x+y " + a);
                System.out.println("Brand x-y " + d);
                System.out.println("Volume x*y " + b);
                System.out.println("division x/y " + c);
            } catch (NumberFormatException e) {
                System.out.println("Input mus be a number");
            } catch (Exception e) {
                System.out.println("Exception occurs " + e.getMessage());
            }
        }
    }
}
