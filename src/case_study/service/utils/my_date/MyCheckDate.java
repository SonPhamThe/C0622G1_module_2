package case_study.service.utils.my_date;

import case_study.service.exception.CheckException;

import java.text.ParseException;
import java.util.Scanner;

public class MyCheckDate {
    private static final Scanner scan = new Scanner(System.in);
    public static MyDate getDateInfo(int minAge, int maxAge) {
        MyDate date;
        while (true)
            try {
                date = new MyDate(scan.nextLine());
                if (date.getAge() < minAge || date.getAge() > maxAge) {
                    throw new CheckException("Age must be from " + minAge + " to " + maxAge + " years old");
                }
                return date;
            } catch (ParseException e) {
                System.out.println("Data is incorrect or not in the format dd/MM/yyyy. Please re-enter!");
            } catch (CheckException e) {
                System.out.println("hello");
            }
    }
}
