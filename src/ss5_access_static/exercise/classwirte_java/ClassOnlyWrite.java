package ss5_access_static.exercise.classwirte_java;

public class ClassOnlyWrite {
    private String name = "John";
    private String clasString = "C02";

    ClassOnlyWrite() {
    }

    ;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClasString() {
        return clasString;
    }

    public void setClasString(String clasString) {
        this.clasString = clasString;
    }
}
