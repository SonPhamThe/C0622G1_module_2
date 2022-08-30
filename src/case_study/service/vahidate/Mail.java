package case_study.service.vahidate;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Mail {
    private static final String MAIL = "\\w+@\\w+.\\w+";

    public static boolean checkMail(String regex) {
        Pattern pattern = Pattern.compile(MAIL);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }
}
