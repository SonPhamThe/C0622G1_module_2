package case_study.service.exception.check_number_of_floor;

import case_study.service.exception.CheckException;

public class CheckNumberOfFloor {
    public static Integer checkNumberOfFloor(int temp) {
        do {
            try {
                if (temp < 0) {
                    throw new CheckException("Input must be >0");
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
