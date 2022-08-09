package ss7_abstractclass_interface.practice.animal_irnterface.model;

import ss7_abstractclass_interface.practice.animal_irnterface.model.eidble.Edible;

public class Chicken extends Animal implements Edible {

    @Override
    public String makeSound() {
        return "Chicken: gà gà";
    }

    @Override
    public String howToEat() {
        return "could be fried";
    }
}
