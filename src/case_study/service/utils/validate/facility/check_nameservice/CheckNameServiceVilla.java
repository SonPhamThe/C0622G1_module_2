package case_study.service.utils.validate.facility.check_nameservice;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckNameServiceVilla {
    private static final String NAME_SERVICE = "SVVL-\\d{4}";

    public static boolean checkVilla(String regex) {
        Pattern pattern = Pattern.compile(NAME_SERVICE);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }
}
