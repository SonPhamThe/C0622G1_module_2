package case_study.service.vahidate;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IdObject {
    private static final String PATH_ID_OBJECT = "\\S+";

    public static boolean checkIdObject(String regex) {
        Pattern pattern = Pattern.compile(PATH_ID_OBJECT);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }
}
