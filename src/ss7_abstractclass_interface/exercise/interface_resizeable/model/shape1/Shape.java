package ss7_abstractclass_interface.exercise.interface_resizeable.model.shape1;

import ss7_abstractclass_interface.exercise.interface_resizeable.model.resizeable.Resizeable;

public class Shape implements Resizeable {
    private String color = "green";
    private boolean filled = true;

    public Shape() {
    }

    public Shape(String color, boolean filled) {
        this.color = color;
        this.filled = filled;
    }

    public Shape(double side, double side1, String color, boolean filled) {
    }


    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    @Override
    public String toString() {
        return " A shape with color of" +
                "color = '" + getColor() + '\'' +
                ", and " + (isFilled() ? "filled" : "not filled");
    }

    @Override
    public void resize(double percent) {
    }
}
