package additional_exercise.bai1;

import java.util.Scanner;

public class MainCandidate {
    public static void main(String[] args) {
        int number;
        number = inputNumber("The number of student");

        Candidate[] array = new Candidate[number];
        inputElementForArray(array);

        for (Candidate candidate : array) {
            if (candidate.getTotalScore() > 15) {
                System.out.println(candidate);
            }
        }
    }

    public static void inputElementForArray(Candidate[] arr) {
        String name = "";
        double mathScore;
        double literatureScore;
        double englishScore;
        int i;
        for (i = 0; i < arr.length; i++) {
            System.out.printf("No = %d, Candidate Name = ", i + 1);

            mathScore = inputScore("Math Score");
            englishScore = inputScore("English Score");
            literatureScore = inputScore("Literature Score");

            Candidate candidate = new Candidate(name, mathScore, literatureScore, englishScore);

            arr[i] = candidate;
        }
    }

    public static int inputNumber(String target) {
        Scanner scan = new Scanner(System.in);

        int number;
        boolean numberIsInvalid;

        System.out.println("Enter " + target);
        do {
            number = Integer.parseInt(scan.nextLine());
            numberIsInvalid = number < 0 || number > 20;
            if (numberIsInvalid) {
                System.out.println("Number is invalid, number must be >=0 and <=20");
            }
        } while (numberIsInvalid);
        return number;
    }

    public static int inputScore(String nameOfVariable) {
        Scanner scanner = new Scanner(System.in);

        int number;
        boolean numberIsInvalid;

        System.out.print("Enter " + nameOfVariable);
        do {
            number = Integer.parseInt(scanner.nextLine());
            numberIsInvalid = number < 0 || number > 10;

            if (numberIsInvalid) {
                System.out.printf("Invalid input value\n" +
                        "Retype %s >=0 and %s <=10", nameOfVariable, nameOfVariable);
            }

        } while (numberIsInvalid);
        return number;
    }
}
