package animals;

import animals.actions.Fly;
import animals.actions.Voice;
import animals.aviarySizeEnum.AviarySize;
import animals.exception.WrongFoodException;
import food.FishFood;
import food.Food;
import food.InsectsFood;
import food.MeatFood;

public class Falcon extends Carnivore implements Fly, Voice {

    public Falcon(String name, AviarySize size) {
        super(name, size, 50, 50);
    }

    @Override
    public void eat(Food food) throws WrongFoodException {
        if (food instanceof MeatFood || food instanceof FishFood || food instanceof InsectsFood) {
            System.out.println("Falcons primarily consume meat, fish and insects. ");
        } else {
            throw new WrongFoodException("Falcons can't eat " + food.getClass().getSimpleName() + ". ");
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
