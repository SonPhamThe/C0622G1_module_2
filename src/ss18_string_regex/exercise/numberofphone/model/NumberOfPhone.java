package ss18_string_regex.exercise.numberofphone.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumberOfPhone {
    private static final String NUMBER_PHONE = "[(][+][8][4][)][-][(][0][1-9]\\d{8}[)]";

    public boolean checkNumberOf(String regex) {
        Pattern pattern = Pattern.compile(NUMBER_PHONE);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();

    }
}
