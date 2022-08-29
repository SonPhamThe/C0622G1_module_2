package case_study.service.exception.check_day_of_birth;

import case_study.service.exception.CheckException;

import java.util.Scanner;

public class CheckDayOfBirth {
    private static final Scanner scan = new Scanner(System.in);
    private static final String DAY_OF_BIRTH = "^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[13-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$";

    public static String checkDayOfBirth(String temp) {
        while (true) {
            try {
                temp = scan.nextLine();
                if (Integer.parseInt(temp.substring(6)) > 2014) {
                    throw new CheckException("Year old must be >18");
                }
                if (Integer.parseInt(temp.substring(6)) < 1922) {
                    throw new CheckException("Year old mus be <100");
                }
                if (!temp.matches(DAY_OF_BIRTH)) {
                    throw new CheckException("Input invalid");
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Day of birth must be a number");
            } catch (CheckException e) {
                System.out.println(e.getMessage());
            }
        }
        return temp;
    }
}
