package case_study.service.validate.facility.check_nameservice;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckNameServiceHouse {
    private static final String NAME_SERVICE = "SVHO-\\d{4}";

    public static boolean checkHouse(String regex) {
        Pattern pattern = Pattern.compile(NAME_SERVICE);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }

}
