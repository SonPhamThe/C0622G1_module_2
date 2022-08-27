package case_study.service.validate.employee;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NamePerson {
    private static final String NAME_OBJECT = "[A-Za-z\\s]+";

    public static boolean checkNameObject(String regex) {
        Pattern pattern = Pattern.compile(NAME_OBJECT);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }
}
