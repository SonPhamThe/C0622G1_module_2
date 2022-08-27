package case_study.model.employee;

import case_study.model.person.Person;

public class Employee extends Person {
    private String employeeId;
    private String level;
    private String location;
    private double wage;

    public Employee(String employeeId, String level, String location, double wage) {
        this.employeeId = employeeId;
        this.level = level;
        this.location = location;
        this.wage = wage;
    }

    public Employee(String nameEmployee, String dayOfBirth, String gender, String CMND, String numberOfPhone, String email, String employeeId, String level, String location, double wage) {
        super(nameEmployee, dayOfBirth, gender, CMND, numberOfPhone, email);
        this.employeeId = employeeId;
        this.level = level;
        this.location = location;
        this.wage = wage;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getLevel() {
        return this.level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public double getWage() {
        return wage;
    }

    public void setWage(double wage) {
        this.wage = wage;
    }

    @Override
    public String toString() {
        return String.format("%s,%s,%s,%s,%s", employeeId, level, location, super.toString(),wage);
//        return "Employee has a Id = " + employeeId +
//                ", level = " + level +
//                ", location = " + location +
//                ", wage = " + wage + super.toString();
    }
}
