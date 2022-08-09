package ss7_abstractclass_interface.practice.animal_irnterface.controller;

import ss7_abstractclass_interface.practice.animal_irnterface.model.*;
import ss7_abstractclass_interface.practice.animal_irnterface.model.eidble.Edible;

public class AbstractAndInterfaceController {
    public static void main(String[] args) {
        Animal[] animal = new Animal[2];
        animal[0] = new Tiger();
        animal[1] = new Chicken();
        for (Animal animals : animal) {
            System.out.println(animals.makeSound());

            if (animals instanceof Chicken) {
                Edible edible = (Chicken) animals;
                System.out.println(edible.howToEat());
            }
        }
        Fruit[] fruits = new Fruit[2];
        fruits[0] = new Apple();
        fruits[1] = new Orange();
        for (Fruit fruit : fruits) {
            System.out.println(fruit.howToEat());
        }
    }
}
