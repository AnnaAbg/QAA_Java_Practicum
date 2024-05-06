import animals.Animals;
import animals.Carnivore;
import animals.Herbivore;
import animals.actions.Voice;
import food.*;

public class Worker {

    public void feedTheAnimal(Animals animal, Food food) {
        animal.eat(food);
        if (animal instanceof Carnivore && food instanceof Grass || food instanceof Leaves) {
            System.out.println("You can't feed a carnivore with grass or leaves!");
        } else if (animal instanceof Herbivore && food instanceof MeatFood || food instanceof FishFood) {
            System.out.println("You can't feed a herbivore with meat or fish food!");
        } else
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
