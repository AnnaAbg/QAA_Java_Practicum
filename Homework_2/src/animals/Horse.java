package animals;

import animals.actions.Run;
import animals.actions.Voice;
import food.Food;
import food.Grass;

public class Horse extends Herbivore implements Run, Voice {

    public Horse() {
        super(50, 50);
    }

    @Override
    public void eat(Food food) {
        if (food instanceof Grass) {
            System.out.println("Horses primarily consume grasses, leaves, seeds, fruits.");
        } else {
            System.out.println("Horses can't eat " + food.getClass().getSimpleName());
        }
    }

    @Override
    public void run() {
        System.out.println("Horses are well-adapted to running across a variety of terrains.");
        decreaseThirst(25);
    }

    @Override
    public String voice() {
        return "\"Neigh...neigh...neigh...\"";
    }
}
