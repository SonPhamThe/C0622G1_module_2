package demo_haitt.demo_exercise1.service.util.validate;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NameClassValidate {
    private static final String NAME_CLASS = "[CA]\\d{4}[GI][1]";

    public static boolean checkNameClass(String regex) {
        Pattern pattern = Pattern.compile(NAME_CLASS);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }
}
