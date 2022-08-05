package ss5_access_static.exercise.access_modifier;

public class TestCircle {
    public static void main(String[] args) {
        Circle circle1 = new Circle(2.0);
        Circle circle2 = new Circle(3.5);

        System.out.println("Radius: " + circle1.getRadius());
        System.out.println("Area: " + circle1.getArea());

        System.out.println("Radius: " + circle2.getRadius());
        System.out.println("Area: " + circle2.getArea());
    }
}

 /*   Nếu thay accessmodifier là default hoặc protected thì chương trình chạy bình thường
         Nếu là private thì chương trình báo lỗi
     */
