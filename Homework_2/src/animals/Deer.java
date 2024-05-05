package animals;

import animals.actions.Run;
import animals.actions.Voice;
import food.Food;
import food.Grass;

public class Deer extends Herbivore implements Run, Voice {

    public Deer() {
        super(50, 50);
    }

    @Override
    public void eat(Food food) {
        if (food instanceof Grass) {
            System.out.println("Deer primarily consume grasses, fruits, nuts.");
        } else {
            System.out.println("Deer can't eat " + food.getClass().getSimpleName() + ". ");
        }
    }

    @Override
    public void run() {
        System.out.println("Deer are running at high speeds when fleeing from predators");
        decreaseThirst(25);
    }

    @Override
    public String voice() {
        return "\"Grunt... grunt...grunt...\"";
    }
}
