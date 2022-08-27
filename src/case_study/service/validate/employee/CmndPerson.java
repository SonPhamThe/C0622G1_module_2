package case_study.service.validate.employee;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CmndPerson {
    private static final String CMND = "\\d{12}";

    public static boolean checkCmnd(String regex) {
        Pattern pattern = Pattern.compile(CMND);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }
}
