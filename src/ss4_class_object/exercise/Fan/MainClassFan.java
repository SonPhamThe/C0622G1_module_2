package ss4_class_object.exercise.Fan;

public class MainClassFan {
    public static void main(String[] args) {
       ClassFan fan1 = new ClassFan();
       fan1.setSpeed(2);
       fan1.setRadius(3.0);
       fan1.setColor("orange");
       fan1.setOn(false);

       ClassFan fan2 = new ClassFan();
        fan2.setSpeed(2);
        fan2.setRadius(4.0);
        fan2.setColor("white");
        fan2.setOn(true);

        System.out.println(fan1);
        System.out.println(fan2);
    }
}
