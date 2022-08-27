package case_study.service.validate.employee;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Mail {
    private static final String EMAIL_EMPLOYEE = "\\w+@\\w+.\\w+";

    public static boolean checkEmail(String regex) {
        Pattern pattern = Pattern.compile(EMAIL_EMPLOYEE);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }
}
