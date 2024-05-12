package animals;

import animals.actions.Run;
import animals.actions.Voice;
import food.FishFood;
import food.Food;
import food.MeatFood;

public class Wolf extends Carnivore implements Run, Voice {

    public Wolf(String name, AviarySize size) {
        super(name, size, 50, 50);
    }

    @Override
    public void eat(Food food) throws WrongFoodException {
        if (food instanceof MeatFood || food instanceof FishFood) {
            System.out.println("Wolves primarily eat meat and fish.");
        } else {
            throw new WrongFoodException("Wolves can't eat " + food.getClass().getSimpleName());
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
