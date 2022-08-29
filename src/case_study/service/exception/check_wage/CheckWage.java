package case_study.service.exception.check_wage;

import case_study.service.exception.CheckException;

import java.util.Scanner;

public class CheckWage {
    private static final Scanner scan = new Scanner(System.in);

    public static Double checkWage(Double temp) {
        do {
            try {
                temp = Double.parseDouble(scan.nextLine());
                if (temp < 0) {
                    throw new CheckException("Id must be >0");
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Score must be a number");
            } catch (CheckException e) {
                System.out.println(e.getMessage());
            }
        } while (true);
        return temp;
    }
}
