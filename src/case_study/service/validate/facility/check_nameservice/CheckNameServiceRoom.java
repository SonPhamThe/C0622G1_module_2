package case_study.service.validate.facility.check_nameservice;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckNameServiceRoom {
    private static final String NAME_SERVICE = "SVRO-\\d{4}";

    public static boolean checkRoom(String regex) {
        Pattern pattern = Pattern.compile(NAME_SERVICE);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }
}
