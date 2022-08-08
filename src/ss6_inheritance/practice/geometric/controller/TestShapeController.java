package ss6_inheritance.practice.geometric.controller;

import ss6_inheritance.practice.geometric.model.Shape;

public class TestShapeController {
    public static void main(String[] args) {
        Shape shape = new Shape();
        System.out.println(shape);

        shape = new Shape("red",false);
        System.out.println(shape);
    }
}
