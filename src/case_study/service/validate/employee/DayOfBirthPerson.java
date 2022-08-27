package case_study.service.validate.employee;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DayOfBirthPerson {
    private static final String DAY_OF_BIRTH = "\\d{1,2}[/]\\d{1,2}[/]\\d{4}";

    public static boolean checkDayOfBirth(String regex) {
        Pattern pattern = Pattern.compile(DAY_OF_BIRTH);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }
}
