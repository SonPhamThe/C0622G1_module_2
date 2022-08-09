package ss7_abstractclass_interface.exercise.interface_colorable.controller;

import ss7_abstractclass_interface.exercise.interface_colorable.model.interface_colorable.Color;
import ss7_abstractclass_interface.exercise.interface_resizeable.model.shape1.Circle;
import ss7_abstractclass_interface.exercise.interface_resizeable.model.shape1.Rectangle;
import ss7_abstractclass_interface.exercise.interface_resizeable.model.shape1.Shape;
import ss7_abstractclass_interface.exercise.interface_resizeable.model.shape1.Square;

public class ColorController {
    public static void main(String[] args) {
        Shape[] shape = new Shape[3];
        shape[0] = new Circle(3.0);
        shape[1] = new Square(5.0);
        shape[2] = new Rectangle(4, 5);

        for (Shape shapes : shape) {
            System.out.println(shapes);
            if (shapes instanceof Color) {
                ((Color) shapes).howToColor();
                System.out.println();
            }
            System.out.println();
        }
    }
}
