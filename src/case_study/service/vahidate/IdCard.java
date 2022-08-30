package case_study.service.vahidate;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IdCard {
    private static final String ID_CARD = "\\d{12}";

    public static boolean checkIdCard(String regex) {
        Pattern pattern = Pattern.compile(ID_CARD);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }
}
