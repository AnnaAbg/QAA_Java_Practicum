package animals;

import animals.actions.Voice;
import food.Food;

public class Worker {

    public void feedTheAnimal(Animals animal, Food food) {
        animal.eat(food);
        System.out.println("The " + animal.getClass().getSimpleName() + " has eaten " + food.getFoodValue()
                + " units of " + food.getClass().getSimpleName());
    }

    public String getVoice(Voice animal) {
        if (animal.getClass().toString().equals("class SalmonFish")) {
            return "Error! Salomon cannot produce sounds.";
        }
        return animal.voice();
    }
}
