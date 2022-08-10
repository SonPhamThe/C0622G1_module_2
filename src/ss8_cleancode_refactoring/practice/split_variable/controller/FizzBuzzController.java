package ss8_cleancode_refactoring.practice.split_variable.controller;

import ss8_cleancode_refactoring.practice.split_variable.model.FizzBuzz;

public class FizzBuzzController {
    public static void main(String[] args) {
        int number = 3;
        String result = FizzBuzz.FizzBuzz(number);
        System.out.println(result);

        int number1 = 5;
        String result1 = FizzBuzz.FizzBuzz(number1);
        System.out.println(result1);

        int number2 = 15;
        String result2 = FizzBuzz.FizzBuzz(number2);
        System.out.println(result2);
    }
}
