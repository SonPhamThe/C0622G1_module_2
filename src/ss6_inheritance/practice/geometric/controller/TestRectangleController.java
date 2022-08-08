package ss6_inheritance.practice.geometric.controller;

import ss6_inheritance.practice.geometric.model.Rectangle;

public class TestRectangleController {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle();
        System.out.println(rectangle);

        rectangle = new Rectangle(5.5,6.0);
        System.out.println(rectangle);

        rectangle = new Rectangle(5.6,5.0,"red",true);
        System.out.println(rectangle);
    }
}
