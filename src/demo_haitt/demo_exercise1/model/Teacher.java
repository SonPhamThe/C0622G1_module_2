package demo_haitt.demo_exercise1.model;

public class Teacher extends Person {
    private String specialize;

    public Teacher(String specialize) {
        this.specialize = specialize;
    }

    public Teacher(int id, String name, String dayOfBirth, String gender, String specialize) {
        super(id, name, dayOfBirth, gender);
        this.specialize = specialize;
    }

    public String getSpecialize() {
        return specialize;
    }

    public void setSpecialize(String specialize) {
        this.specialize = specialize;
    }

    @Override
    public String toString() {
        return " Person is a teacher have a " +
                "specialize = " + specialize+super.toString();
    }
}
