package ss6_inheritance.exercise.point_moveablepoint.controller;

import ss6_inheritance.exercise.point_moveablepoint.model.MovablePoint;
import ss6_inheritance.exercise.point_moveablepoint.model.Point;

public class MainController {
    public static void main(String[] args) {
        Point point = new Point();
        System.out.println(point);

        point = new Point(4.5f, 3.4f);
        System.out.println(point);

        MovablePoint movablePoint = new MovablePoint();
        System.out.println(movablePoint);

        movablePoint = new MovablePoint(2.5f, 5.0f, 4.5f, 3.0f);
        System.out.println(movablePoint);

        System.out.println(movablePoint.move());
    }
}
