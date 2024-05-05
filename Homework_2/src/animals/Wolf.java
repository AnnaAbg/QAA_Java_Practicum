package animals;

import animals.actions.Run;
import animals.actions.Voice;
import food.Food;
import food.Meat;

public class Wolf extends Carnivore implements Run, Voice {

    public Wolf() {
        super(50, 50);
    }

    @Override
    public void eat(Food food) {
        if (food instanceof Meat) {
            System.out.println("Wolves primarily consume " + food.getClass().getSimpleName());
        } else {
            System.out.println("Wolves can't eat " + food.getClass().getSimpleName());
        }
    }

    @Override
    public void run() {
        System.out.println("Wolfs are galloping when chasing a prey");
        decreaseHungerLevel(30);
    }

    @Override
    public String voice() {
        return "\"Howl...howl...howl...\"";
    }
}
