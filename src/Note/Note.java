package Note;

import java.util.Scanner;

public class Note {
    public static void main(String[] args) {
        int a = inputPositive("a");
        int b = inputPositive("b");
        int c = inputPositive("c");

        long factorial = getFactorialN(a);
        long factorialB = getFactorialN(b);
        long factorialC = getFactorialN(c);

        long sum = factorial + factorialB + factorialC;

        System.out.printf("%d!+%d!+%d!= %d", a, b, c, sum);

    }

    // phương thức tính giai thừa
    public static long getFactorialN(int n) {
        long factorialA = 1;
        for (int i = 2; i <= n; i++) {
            factorialA *= i;
        }
        return factorialA;
    }

    // phương thức nhập số sai và bắt nhập lại
    public static int inputPositive(String target) {
        Scanner scan = new Scanner(System.in);
        int n;
        boolean isInvalidA;
        System.out.printf("Enter number %s: ", target);
        do {
            n = Integer.parseInt(scan.nextLine());
            isInvalidA = n < 0;
            if (isInvalidA) {
                System.out.printf("%s phải >=0, xin hãy nhập lại\n", target);
            }
        } while (isInvalidA);
        return n;
    }
}
