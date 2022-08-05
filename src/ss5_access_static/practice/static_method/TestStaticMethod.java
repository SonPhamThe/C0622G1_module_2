package ss5_access_static.practice.static_method;

public class TestStaticMethod {
    public static void main(String[] args) {
        StaticMethod.change();

        StaticMethod s1 = new StaticMethod(111, "Son");
        StaticMethod s2 = new StaticMethod(222, "Peter");
        StaticMethod s3 = new StaticMethod(222, "Villa");

        s1.display();
        s2.display();
         s3.display();
    }
}
