package case_study.service.vahidate;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NameLocation {
    private static final String NAME_LOCATION = "^\\p{Lu}\\p{Ll}+(\\s\\p{Lu}\\p{Ll}+)*$";

    public static boolean checkNameLocation(String regex) {
        Pattern pattern = Pattern.compile(NAME_LOCATION);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }
}
