package animals;

import animals.actions.Swim;
import animals.aviarySizeEnum.AviarySize;
import animals.exception.WrongFoodException;
import food.FishFood;
import food.Food;

public class Whale extends Carnivore implements Swim {

    public Whale(String name, AviarySize size) {
        super(name, size, 50, 50);
    }

    @Override
    public void eat(Food food) throws WrongFoodException {
        if (food instanceof FishFood) {
            System.out.println("Whales primarily eat fish. ");
        } else {
            throw new WrongFoodException("Whale can't eat " + food.getClass().getSimpleName());
        }
    }

    @Override
    public void swim() {
        System.out.println("Salmon swim upstream.");
    }
}

