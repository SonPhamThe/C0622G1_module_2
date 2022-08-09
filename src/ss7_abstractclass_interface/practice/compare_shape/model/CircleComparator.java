package ss7_abstractclass_interface.practice.compare_shape.model;

import ss6_inheritance.practice.geometric.model.Circle;

import java.util.Comparator;

public class CircleComparator implements Comparator<Circle> {
    @Override
    public int compare(Circle o1, Circle o2) {
        return Double.compare(o1.getRadius(), o2.getRadius());
    }
}
