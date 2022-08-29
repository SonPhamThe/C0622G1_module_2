package case_study.service.utils.validate.employee;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Location {
    private static final String LOCATION_OBJECT = "^\\p{Lu}\\p{Ll}+(\\s\\p{Lu}\\p{Ll}+)*$";

    public static boolean checkLocationObject(String regex) {
        Pattern pattern = Pattern.compile(LOCATION_OBJECT);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }
}
