package animals;

import animals.actions.Swim;
import food.AquaticPlants;
import food.FishFood;
import food.Food;
import food.MeatFood;

public class SalmonFish extends Carnivore implements Swim {

    public SalmonFish() {
        super(50, 50);
    }

    @Override
    public void eat(Food food) {
        if (food instanceof FishFood) {
            System.out.println("Salmon primarily eat small fish. ");
        } else {
            System.out.println("Salmon can't eat " + food.getClass().getSimpleName());
        }
    }

    @Override
    public void swim() {
        System.out.println("Salmon swim upstream.");
    }
}

