package ss6_inheritance.practice.geometric.model;

public class Rectangle extends Shape {
    private double width = 1.0;
    private double length = 1.0;

    public Rectangle(double width, double length) {
        this.length = length;
        this.width = width;
    }

    public Rectangle(double width, double length, String color, boolean filled) {
        super(color,filled);
        this.width = width;
        this.length = length;
    }

    public Rectangle() {
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getArea() {
        return width*length;
    }

    public double getPerimeter() {
        return 2*(width+length);
    }

    @Override
    public String toString() {
        return "A Rectangle with a " +
                "width = " + getWidth() +
                ",and a length = " + getLength() +
                " which is a subclass of "+ super.toString();
    }
}
