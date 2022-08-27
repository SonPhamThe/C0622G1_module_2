package case_study.service.validate.employee;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumberOfPhone {
    private static final String NUMBER_PHONE = "[8][4][-][1-9]\\d{8}";

    public static boolean checkNumberOf(String regex) {
        Pattern pattern = Pattern.compile(NUMBER_PHONE);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();

    }
}
