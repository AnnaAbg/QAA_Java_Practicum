package animals;

import animals.actions.Run;
import animals.actions.Swim;
import animals.actions.Voice;
import food.*;

public class Duck extends Herbivore implements Swim, Run, Voice {


    public Duck() {
        super(50, 50);
    }

    @Override
    public void eat(Food food) {
        if (( food instanceof FishFood || food instanceof AquaticPlants)){
            System.out.println("Ducks are omnivores, can eat both plants and meat. ");
        }
    }

    @Override
    public void run() {
        System.out.println("Ducks swim gracefully on the water surface.");
        decreaseThirst(10);
        decreaseHungerLevel(15);
    }

    @Override
    public void swim() {
        System.out.println("Ducks waddle when moving on land.");
    }

    @Override
    public String voice() {
        return "\"Quack...quack...quack...\"";
    }
}
