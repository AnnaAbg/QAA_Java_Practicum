package animals;

import animals.actions.Run;
import animals.actions.Voice;
import food.Food;
import food.Grass;
import food.Leaves;

public class Horse extends Herbivore implements Run, Voice {

    public Horse(String name, AviarySize size) {
        super(name, size, 50, 50);
    }

    @Override
    public void eat(Food food) throws WrongFoodException {
        if (food instanceof Leaves || food instanceof Grass) {
            System.out.println("Horses primarily consume leaves and field grasses. ");
        } else {
            throw new WrongFoodException("Horses can't eat " + food.getClass().getSimpleName());
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
