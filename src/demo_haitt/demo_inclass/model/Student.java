package demo_haitt.demo_inclass.model;

public class Student {
    private int id;
    private String name;
    private String dayOfBirth;
    private double score;
    private String nameClass;

    public Student() {
    }

    public Student(int id, String name, String dayOfBirth, double score, String nameClass) {
        this.id = id;
        this.name = name;
        this.dayOfBirth = dayOfBirth;
        this.score = score;
        this.nameClass = nameClass;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDayOfBirth() {
        return dayOfBirth;
    }

    public void setDayOfBirth(String dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public String getNameClass() {
        return nameClass;
    }

    public void setNameClass(String nameClass) {
        this.nameClass = nameClass;
    }

    @Override
    public String toString() {
        return "Student is have a " +
                "id = " + id +
                ", name = " + name +
                ", dayOfBirth = " + dayOfBirth +
                ", score = " + score +
                ", nameClass = " + nameClass;
    }
}
