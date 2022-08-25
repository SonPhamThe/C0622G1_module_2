package ss18_string_regex.practice.validate_account.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateAccount {
    private static final String accountValidate = "[_a-z0-9]{6,}";

    public ValidateAccount() {
    }

    public boolean validate(String regex) {
        Pattern pattern = Pattern.compile(accountValidate);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }
}
