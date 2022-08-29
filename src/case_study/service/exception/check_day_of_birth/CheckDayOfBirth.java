package case_study.service.exception.check_day_of_birth;

import case_study.service.exception.CheckException;

public class CheckDayOfBirth {

    private static final String DAY_OF_BIRTH = "^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[13-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$";

    public static String checkDayOfBirth(String temp) {
        do {
            try {
                if (Integer.parseInt(temp.substring(6)) > 2014) {
                    throw new CheckException("Year old must be >18");
                }
                if(!temp.matches(DAY_OF_BIRTH)) {
                    throw new CheckException("Input invalid");
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Score must be a number");
            } catch (CheckException e) {
                System.out.println(e.getMessage());
            }
        } while (true);
        return temp;
    }
}
