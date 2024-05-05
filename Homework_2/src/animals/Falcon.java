package animals;

import animals.actions.Fly;
import animals.actions.Voice;
import food.Food;
import food.Meat;

public class Falcon extends Carnivore implements Fly, Voice {

    public Falcon() {
        super(50, 50);
    }

    @Override
    public void eat(Food food) {
        if (food instanceof Meat) {
            System.out.println("Falcons primarily consume birds, insects, reptiles.");
        } else {
            System.out.println("Falcon can't eat " + food.getClass().getSimpleName() + ". ");
        }
    }

    @Override
    public void fly() {
        System.out.println("Falcons fly at speeds exceeding 386 kilometers per hour.");
        decreaseHungerLevel(25);
    }

    @Override
    public String voice() {
        return "\"Screech...screech...screech...\"";
    }
}
