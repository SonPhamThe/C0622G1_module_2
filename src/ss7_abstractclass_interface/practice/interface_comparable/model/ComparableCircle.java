package ss7_abstractclass_interface.practice.interface_comparable.model;

import ss6_inheritance.practice.geometric.model.Circle;

public class ComparableCircle extends Circle implements Comparable<ComparableCircle> {
    public ComparableCircle() {
    }

    public ComparableCircle(double radius) {
        super(radius);
    }

    public ComparableCircle(double radius, String color, boolean filled) {
        super(radius,color,filled);
    }

    @Override
    public int compareTo(ComparableCircle o) {
        return Double.compare(getRadius(), o.getRadius());
    }
}
