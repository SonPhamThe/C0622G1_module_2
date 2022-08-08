package ss6_inheritance.exercise.circle_cylinder.model;

public class Cylinder extends Circle {
    private double height = 5.5;

    public Cylinder() {
    }

    ;

    public Cylinder(double height) {
        this.height = height;
    }

    public Cylinder(double height, double radius, String color) {
        super(radius, color);
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getVolume() {
        return this.height * getRadius() * getRadius() * Math.PI;
    }

    @Override
    public String toString() {
        return "The Cylinder has a height = " + height +
                " and has a Volume = " + getVolume() + " which a subclass of " + super.toString();
    }
}
