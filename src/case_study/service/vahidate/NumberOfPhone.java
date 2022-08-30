package case_study.service.vahidate;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumberOfPhone {
    private static final String PATH_NUMBER_OF_PHONE = "84-[1-9]\\d{8}";

    public static boolean checkNumberOfPhone(String regex) {
        Pattern pattern = Pattern.compile(PATH_NUMBER_OF_PHONE);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }
}
