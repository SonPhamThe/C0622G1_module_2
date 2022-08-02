package ss1_introduction.exercise;

import java.util.Scanner;

public class ConvertMoney {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter dolar you want to convert: ");
        double USD = scanner.nextDouble();
        int rate = 23000;
        double VND = USD * rate;
        System.out.println("Gía tiền VND bạn muốn đổi: " + VND);
    }
}
