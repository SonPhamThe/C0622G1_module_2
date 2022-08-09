package ss7_abstractclass_interface.exercise.interface_colorable.model.shape;


import ss7_abstractclass_interface.exercise.interface_colorable.model.interface_colorable.Color;

public class Square extends Shape implements Color {

    private double side;

    public Square() {

    }

    public Square(double side) {
        this.side = side;
    }

    public Square(double side, String color, boolean filled) {
        super(color, filled);
        this.side = side;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    public double getArea() {
        return side * side;
    }

    @Override
    public String toString() {
        return "A Square with side = " +
                getSide() +
                ", which is a subclass of " + super.toString();
    }

    @Override
    public String howToColor() {
        return " Color all four sides..";
    }
}
