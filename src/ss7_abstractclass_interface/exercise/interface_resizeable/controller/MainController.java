package ss7_abstractclass_interface.exercise.interface_resizeable.controller;

import ss7_abstractclass_interface.exercise.interface_resizeable.model.shape1.Circle;
import ss7_abstractclass_interface.exercise.interface_resizeable.model.shape1.Rectangle;
import ss7_abstractclass_interface.exercise.interface_resizeable.model.shape1.Shape;
import ss7_abstractclass_interface.exercise.interface_resizeable.model.shape1.Square;

public class MainController {
    public static void main(String[] args) {
        Shape[] shape = new Shape[3];
        shape[0] = new Circle(2.0);
        shape[1] = new Rectangle(5,10);
        shape[2] = new Square(10.0);

        for (Shape shapes : shape) {
            shapes.resize(Math.floor(Math.random()*100));
            System.out.println(shapes);
            System.out.println();
        }
    }
}