package demo_haitt.demo_exercise1.service.impl;

import demo_haitt.demo_exercise1.model.Student;
import demo_haitt.demo_exercise1.service.Exception.numberformatexception.InfoException;
import demo_haitt.demo_exercise1.service.IStudent;
import demo_haitt.demo_exercise1.service.util.ReadFile;
import demo_haitt.demo_exercise1.service.util.WriteFIle;
import org.w3c.dom.ls.LSOutput;

import java.io.IOException;
import java.util.*;

public class StudentService implements IStudent {
    private static final Scanner scan = new Scanner(System.in);
    static List<Student> students;

    private static final String path = "src/demo_haitt/demo_exercise1/data/person.txt";

//    static {
//        students.add(new Student(5, "son", "12/04/1999", "male", "ab", 6));
//        students.add(new Student(6, "vinh", "15/05/1999", "male", "ac", 9));
//        students.add(new Student(7, "peter", "13/06/1999", "male", "ad", 8));
//    }

    @Override
    public void displayStudent() throws IOException {
        System.out.println("-------------List the student----------");
        students = ReadFile.readStudentFile(path);
        if (students.size() == 0) {
            System.out.println("List the student is empty");
        }

        for (Student student : students) {
            System.out.println(student.toString());
        }
    }

    @Override
    public void addNewStudent() throws IOException {
        students = ReadFile.readStudentFile(path);
        Student student = this.infoStudent();
        students.add(student);
        System.out.println("Successful add");
        WriteFIle.writeStudentFile(path, students);
    }

    @Override
    public void deleteStudent() {
        students = ReadFile.readStudentFile(path);
        Student student = this.findStudent();
        if (student == null) {
            System.out.println("Not found student valid");
        } else {
            System.out.println("Are you sure want to delete");
            System.out.println("1. Yes, I'm sure\n2. No, I don't");
            int choice = Integer.parseInt(scan.nextLine());
            if (choice == 1) {
                students.remove(student);
                System.out.println("Successful is delete");
            }
        }
    }

    @Override
    public void sortScore() throws IOException {
        students = ReadFile.readStudentFile(path);
        System.out.println("Select sort by name from: " +
                "\n 1. Big to small" +
                "\n 2. Small to big" +
                "\n 3. Exit");
        int choose = Integer.parseInt(scan.nextLine());
        switch (choose) {
            case 1:
                students.sort((a, b) -> (int) (b.getScore() - a.getScore()));
                System.out.println("Success sort");
                break;
            case 2:
                students.sort((a, b) -> (int) (a.getScore() - b.getScore()));
                System.out.println("Success sort");
                break;
            case 3:
                System.exit(0);
            default:
                System.out.println("Your selection is not suitable, selections from 1 to 3");
        }
        WriteFIle.writeStudentFile(path, students);
    }

    @Override
    public void sortName() throws IOException {
        students = ReadFile.readStudentFile(path);
        System.out.println("Welcome to the programing");

        boolean needNextPass = true;
        for (int k = 0; k < students.size() - 1 && needNextPass; k++) {
            needNextPass = false;
            for (int i = 0; i < students.size() - 1 - k; i++) {

                if (students.get(i).getName().compareTo(students.get(i + 1).getName()) > 0) {
                    needNextPass = true;
                    Student temp = students.get(i + 1);
                    students.set(i + 1, students.get(i));
                    students.set(i, temp);
                }

            }
        }
        WriteFIle.writeStudentFile(path, students);

        System.out.println("Success sort");
    }

    @Override
    public void displayStudentOptional() {
        System.out.println("Please enter score to display student");
        int score = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getScore() >= score) {
                System.out.println("List student has a score >= " + score);
                System.out.println(students.get(i).toString());
            }
        }
    }

    @Override
    public void editStudent() throws IOException {
        students = ReadFile.readStudentFile(path);

        Student student = this.findStudent();

        int positionEdit = students.indexOf(student);

        if (student == null) {
            System.out.println("No have id in list student");
        }
        int chooseEdit;
        do {
            System.out.println("--------------------------");
            System.out.println("Student need edit" +
                    "\n 1. Id" +
                    "\n 2. Name of student" +
                    "\n 3. Day of birth student" +
                    "\n 4. Gender of student" +
                    "\n 5. Score" +
                    "\n 6. Name Class of student" +
                    "\n 7. Exit");
            try {
                chooseEdit = Integer.parseInt(scan.nextLine());
            } catch (NumberFormatException e) {
                throw new RuntimeException(e);
            }
            switch (chooseEdit) {
                case 1:
                    int idEdit;
                    do {
                        System.out.println("Enter id to edit of Student");
                        try {
                            idEdit = Integer.parseInt(scan.nextLine());
                            if (idEdit < 0) {
                                throw new InfoException("Id must be >0");
                            }
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("Id must be a number");
                        } catch (InfoException e) {
                            System.out.println(e.getMessage());
                        }
                    } while (true);
                    students.get(positionEdit).setId(idEdit);
                    System.out.println("Success Edit");
                    break;
                case 2:
                    String nameStudentEdit;
                    do {
                        System.out.println("Enter name of Student");
                        try {
                            nameStudentEdit = (scan.nextLine());
                            String str;
                            for (int i = 0; i < nameStudentEdit.length(); i++) {
                                str = "";
                                if ((str + nameStudentEdit.charAt(i)).matches("\\d+")) {
                                    throw new InfoException("Input invalid");
                                }
                            }

                            break;
                        } catch (InfoException e) {
                            System.out.println(e.getMessage());
                        }
                    } while (true);
                    students.get(positionEdit).setName(nameStudentEdit);
                    System.out.println("Success Edit");
                    break;
                case 3:
                    System.out.println("Enter day of birth want to edit");
                    String dayOfBirthEdit = scan.nextLine();
                    students.get(positionEdit).setDayOfBirth(dayOfBirthEdit);
                    System.out.println("Success Edit");
                    break;
                case 4:
                    System.out.println("Enter gender of Student want to edit");
                    String genderEdit = scan.nextLine();
                    students.get(positionEdit).setGender(genderEdit);
                    System.out.println("Success Edit");
                    break;
                case 5:
                    System.out.println("Enter score want to edit");
                    double scoreEdit = Double.parseDouble(scan.nextLine());
                    students.get(positionEdit).setScore(scoreEdit);
                    System.out.println("Success Edit");
                    break;
                case 6:
                    System.out.println("Enter name of class want to edit");
                    String nameOfClassEdit = scan.nextLine();
                    students.get(positionEdit).setNameClass(nameOfClassEdit);
                    System.out.println("Success Edit");
                    break;
                case 7:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Your selection is not suitable, selections from 1 to 4");
            }
            break;
        } while (true);
        WriteFIle.writeStudentFile(path, students);
    }

    public Student findStudent() {
        students = ReadFile.readStudentFile(path);
        System.out.println("Enter id student you want to find");
        int id = Integer.parseInt(scan.nextLine());
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }

    public Student infoStudent() throws IOException {
        int id;
        do {
            System.out.println("Enter id of Student");
            try {
                id = Integer.parseInt(scan.nextLine());
                if (id < 0) {
                    throw new InfoException("Id must be >0");
                }
                for (Student student : students) {
                    if (student.getId() == id) {
                        throw new InfoException("The id has been matched");
                    }
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Id must be a number");
            } catch (InfoException e) {
                System.out.println(e.getMessage());
            }
        } while (true);

        String name;
        do {
            System.out.println("Enter name of Student");
            try {
                name = (scan.nextLine());
                String str;
                for (int i = 0; i < name.length(); i++) {
                    str = "";
                    if ((str + name.charAt(i)).matches("\\d+")) {
                        throw new InfoException("Input invalid");
                    }
                }

                break;
            } catch (InfoException e) {
                System.out.println(e.getMessage());
            }
        } while (true);

        String dayOfBirth;
        do {
            try {
                System.out.print("Enter day of birth: ");
                dayOfBirth = scan.nextLine();
                if (!dayOfBirth.matches("\\d+\\d+\\W+\\d+\\d+\\W+\\d+\\d+\\d+\\d")) {
                    throw new InfoException("Invalid input data");
                }
                if (Integer.parseInt(dayOfBirth.substring(0, 1).concat(dayOfBirth.substring(1, 2))) > 31) {
                    throw new InfoException("Invalid input data");
                }
                if (Integer.parseInt(dayOfBirth.substring(3, 4).concat(dayOfBirth.substring(4, 5))) > 12) {
                    throw new InfoException("Invalid input data");
                }
                if (!checkDayMonthYear(dayOfBirth)) {
                    throw new InfoException("Invalid input data");
                }
                if (Integer.parseInt(dayOfBirth.substring(6)) > 2015) {
                    throw new InfoException("Invalid input data");
                }
                break;
            } catch (InfoException e) {
                System.out.println(e.getMessage());
            }
        } while (true);

        String gender;
        do {
            System.out.println("Enter gender of Student");
            try {
                gender = scan.nextLine();
                if (!gender.equals("male") && !gender.equals("female")) {
                    throw new InfoException("Let enter gender is male or female, don't input exception");
                }
                break;
            } catch (InfoException e) {
                System.out.println("Let enter gender is male or female, don't input exception");
                ;
            }
        } while (true);

        String nameClass;
        while (true) {
            try {
                System.out.print("Enter name of class: ");
                nameClass = scan.nextLine();
                if (!nameClass.matches("\\d+\\d+\\W+\\d")) {
                    throw new InfoException("Invalid input data");
                }
                break;
            } catch (InfoException e) {
                System.out.println(e.getMessage());
            }
        }

        double score;
        do {
            System.out.println("Enter score of Student");
            try {
                score = Double.parseDouble(scan.nextLine());
                if (score < 0 || score > 100) {
                    throw new InfoException("Id must be >0 & <100");
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Score must be a number");
            } catch (InfoException e) {
                System.out.println(e.getMessage());
            }
        } while (true);

        return new Student(id, name, dayOfBirth, gender, nameClass, score);
    }

    public static boolean checkDayMonthYear(String string) {
        int[] day = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int[] arr = new int[3];
        arr[0] = Integer.parseInt(string.substring(0, 1).concat(string.substring(1, 2)));
        arr[1] = Integer.parseInt(string.substring(3, 4).concat(string.substring(4, 5)));
        arr[2] = Integer.parseInt(string.substring(6));
        if (arr[2] % 4 == 0 && !(arr[2] % 100 == 0 && arr[2] % 400 != 0)) {
            arr[0] = day[arr[1] - 1] + 1;
        }
        return (arr[0] <= day[arr[1] - 1]);
    }

    private int checkId() throws IOException {
        students = ReadFile.readStudentFile(path);
        int nextId = 0;
        if (students.size() == 0) {
            return 1;
        } else {
            nextId = students.get(0).getId();
            for (Student student : students) {
                if (nextId < student.getId()) {
                    nextId = student.getId();
                }
            }
        }
        return nextId + 1;
    }
}
