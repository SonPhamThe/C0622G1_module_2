package ss6_inheritance.exercise.point2D_point3D.controller;

import ss6_inheritance.exercise.point2D_point3D.model.Point2D;
import ss6_inheritance.exercise.point2D_point3D.model.Point3D;

public class MainController {
    public static void main(String[] args) {
        Point2D point2d = new Point2D();
        System.out.println(point2d);

        point2d = new Point2D(2.5f, 4.0f);
        System.out.println(point2d);

        Point3D point3D = new Point3D();
        System.out.println(point3D);

        point3D = new Point3D(3.2f, 2.0f, 1.5f);
        System.out.println(point3D);
    }
}
