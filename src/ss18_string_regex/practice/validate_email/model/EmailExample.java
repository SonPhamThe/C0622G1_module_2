package ss18_string_regex.practice.validate_email.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailExample {
    private static Pattern pattern;
    private Matcher matcher;

    private static final String emailRegex = "\\w+@\\w+.\\w+";

    public EmailExample() {
        pattern = Pattern.compile(emailRegex);
    }

    public boolean validate(String regex) {
        matcher = pattern.matcher(regex);
        return matcher.matches();
    }
}
