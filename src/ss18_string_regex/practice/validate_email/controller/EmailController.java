package ss18_string_regex.practice.validate_email.controller;

import ss18_string_regex.practice.validate_email.model.EmailExample;

public class EmailController {
    public static final String[] validEmail = new String[]{"a@gmail.com", "b@gmail.com", "c@gmail.com"};
    public static final String[] invalidEmail = new String[]{"@gmail.com", "b@gmail.", "@#abc@gmail.com"};

    public static void main(String[] args) {
        EmailExample emailExample = new EmailExample();
        for (String email : validEmail) {
            boolean isValid = emailExample.validate(email);
            System.out.println("Email is " + email + " is valid: " + isValid);
        }
        for (String email : invalidEmail) {
            boolean isValid = emailExample.validate(email);
            System.out.println("Email is " + email + " is valid: " + isValid);
        }
    }
}
