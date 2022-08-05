package ss5_access_static.practice.static_method;

public class StaticMethod {
    private int roll;
    private String name;
    private static String college = "Bach KHoa";

    StaticMethod(int r, String n) {
        roll = r;
        name = n;
    }

    static void change() {
        college = "CodeGym";
    }

    void display() {
        System.out.println(roll + " " + name + " " + college);
    }
}
