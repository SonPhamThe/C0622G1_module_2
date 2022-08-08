package ss6_inheritance.exercise.triangle.model;

import ss6_inheritance.practice.geometric.model.Shape;

public class Triangle extends Shape {
    private double side1 = 1.0;
    private double side2 = 1.0;
    private double side3 = 1.0;

    public Triangle() {
    }

    public Triangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    public double getSide1() {
        return side1;
    }

    public void setSide1(double side1) {
        if (side1 < 0) {
            System.out.println("Enter again side 1 please, side1 must be >0: ");
        } else {
            this.side1 = side1;
        }
    }

    public double getSide2() {
        return side2;
    }

    public void setSide2(double side2) {
        if (side2 < 0) {
            System.out.println("Enter again side 2 please, side2 must be >0: ");
        } else {
            this.side2 = side2;
        }
    }

    public double getSide3() {
        return side3;
    }

    public void setSide3(double side3) {
        if (side3 < 0) {
            System.out.println("Enter again side 3 please, side3 must be >0: ");
        } else {
            this.side3 = side3;
        }
    }

    double p = this.side1 + this.side2 + this.side3;

    public double getArea() {
        return Math.sqrt(p * (p - this.side1) * (p - this.side2) * (p - this.side3));
    }

    public double getPerimeter() {
        return p;
    }

    @Override
    public String toString() {
        return "Triangle has a " +
                "side1 = " + side1 +
                ", side2 = " + side2 +
                ", side3 = " + side3 +
                ", p = " + p + super.toString();
    }
}
