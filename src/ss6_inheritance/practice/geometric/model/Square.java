package ss6_inheritance.practice.geometric.model;

public class Square extends Rectangle {
    public Square() {};

    public Square(double side) {
        super(side,side);
    }

    public Square(double side, String color, boolean filled) {
        super(side, side, color,filled);
    }

    public double getSide() {
        return getWidth();
    }

    public void setSide(double side) {
        setWidth(side);
        setLength(side);
    }

    @Override
    public String toString() {
        return "A square with side = "+getSide()+", which is a class of "+super.toString();
    }
}
