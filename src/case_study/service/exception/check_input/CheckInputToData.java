package case_study.service.exception.check_input;

import case_study.service.exception.CheckException;

public class CheckInputToData {
    public static Double checkInputToDouble(double temp) {
        do {
            try {
                if (temp < 30) {
                    throw new CheckException("Id must be > 30");
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

    public static Integer checkInputToInteger(int temp) {
        do {
            try {
                if (temp < 0) {
                    throw new CheckException("Input must be >0");
                }
                if (temp >= 20) {
                    throw new CheckException("Input must be <20");
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

    public static String checkInputToString(String string) {
        try {
            if (!string.matches("\\d+")) {
                throw new CheckException("Input must be valid");
            }
        } catch (CheckException e) {
            throw new RuntimeException(e);
        }
        return string;
    }
}
