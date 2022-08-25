package ss18_string_regex.exercise.nameclass.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NameClass {
    private static final String nameClass = "[A-Z]\\d{4}[A-Z]";

    public boolean checkNameClass(String regex) {
        Pattern pattern = Pattern.compile(nameClass);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }
}
