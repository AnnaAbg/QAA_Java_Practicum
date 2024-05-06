package animals;

import food.Food;
import food.Grass;
import food.MeatFood;

public abstract class Carnivore extends Animals {

    public Carnivore(int hungerLevel, int thirst) {
        super(hungerLevel, thirst);
    }
}
