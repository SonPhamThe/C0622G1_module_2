package ss8_cleancode_refactoring.practice.split_variable.model;

public class FizzBuzz {
    public static String FizzBuzz(int number) {
        boolean isBuzz = number % 5 == 0;
        boolean isFizz = number % 3 == 0;
        if (isBuzz && isFizz) return "FizzBuzz";
        if (isFizz) return "Fizz";
        if (isBuzz) return "Buzz";
        return number + "";
    }
}
