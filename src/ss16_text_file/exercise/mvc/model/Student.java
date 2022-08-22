package ss16_text_file.exercise.mvc.model;

import demo_haitt.demo_exercise1.model.Person;

public class Student extends Person {
    private String nameClass;
    private double score;

    public Student(String nameClass, double score) {
        this.nameClass = nameClass;
        this.score = score;
    }

    public Student(int id, String name, String dayOfBirth, String gender, String nameClass, double score) {
        super(id, name, dayOfBirth, gender);
        this.nameClass = nameClass;
        this.score = score;
    }

    public String getNameClass() {
        return nameClass;
    }

    public void setNameClass(String nameClass) {
        this.nameClass = nameClass;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Person is a student have a " +
                "nameClass = " + nameClass +
                ", score = " + score + super.toString();
    }

//    @Override
//    public int compareTo(Student o) {
//        return (int) (this.getScore() - o.getScore());
//    }
}
