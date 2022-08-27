package case_study.service.validate.employee;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Location {
    private static final String LOCATION_OBJECT = "[A-Za-z\\s]+";

    public static boolean checkLocationObject(String regex) {
        Pattern pattern = Pattern.compile(LOCATION_OBJECT);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }
}
