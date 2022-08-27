package case_study.model.person;

public abstract class Person {
    private String name;
    private String dayOfBirth;
    private String gender;
    private String CMND;
    private String numberOfPhone;
    private String email;

    public Person() {
    }


    public String getNameEmployee() {
        return name;
    }

    public void setNamePerson(String nameEmployee) {
        this.name = nameEmployee;
    }

    public String getDayOfBirth() {
        return dayOfBirth;
    }

    public void setDayOfBirth(String dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCMND() {
        return CMND;
    }

    public void setCMND(String CMND) {
        this.CMND = CMND;
    }

    public String getNumberOfPhone() {
        return numberOfPhone;
    }

    public void setNumberOfPhone(String numberOfPhone) {
        this.numberOfPhone = numberOfPhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public Person(String nameEmployee, String dayOfBirth, String gender, String CMND, String numberOfPhone, String email) {
        this.name = nameEmployee;
        this.dayOfBirth = dayOfBirth;
        this.gender = gender;
        this.CMND = CMND;
        this.numberOfPhone = numberOfPhone;
        this.email = email;
    }

    @Override
    public String toString() {
        return String.format("%s,%s,%s,%s,%s,%s", name, dayOfBirth, gender, CMND, numberOfPhone, email);
//        return " and has " +
//                "nameEmployee = " + name+
//                ", dayOfBirth = " + dayOfBirth+
//                ", gender = " + gender+
//                ", CMND = " + CMND +
//                ", numberOfPhone = " + numberOfPhone +
//                ", email = " + email;
    }
}
