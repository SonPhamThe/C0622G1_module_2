package case_study.service.validate.employee;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Level {
    private static final String LEVEL_OBJECT = "[A-Za-z\\s]+";

    public static boolean checkLevelObject(String regex) {
        Pattern pattern = Pattern.compile(LEVEL_OBJECT);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }
}
