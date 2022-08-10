package ss8_cleancode_refactoring.practice.change_variable.controller;

import ss8_cleancode_refactoring.practice.change_variable.model.Calculator;

import java.util.Scanner;

public class CalculatorController {
    public static void main(String[] args) {
        int firstOperand = 3;
        int secondOperand = 0;
        char operator = '+';
        char operator1 = '-';
        char operator2 = '*';
        char operator3 = '/';

        int result = Calculator.calculate(firstOperand, secondOperand, operator);
        System.out.println(result);

        int result1 = Calculator.calculate(firstOperand, secondOperand, operator1);
        System.out.println(result1);

        int result2 = Calculator.calculate(firstOperand, secondOperand, operator2);
        System.out.println(result2);

        int result3 = Calculator.calculate(firstOperand, secondOperand, operator3);
        System.out.println(result3);
    }
}


