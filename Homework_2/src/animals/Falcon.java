package animals;

import animals.actions.Fly;
import animals.actions.Voice;
import food.FishFood;
import food.Food;
import food.InsectsFood;
import food.MeatFood;

public class Falcon extends Carnivore implements Fly, Voice {

    public Falcon() {
        super(50, 50);
    }

    @Override
    public void eat(Food food) {
        if (food instanceof MeatFood || food instanceof FishFood || food instanceof InsectsFood) {
            System.out.println("Falcons primarily consume meat, fish and insects. ");
        } else {
            System.out.println("Falcons can't eat " + food.getClass().getSimpleName() + ". ");
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
