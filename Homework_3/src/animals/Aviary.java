package animals;

import java.util.HashMap;
import java.util.Map;

public class Aviary<T extends Animals> {

    private HashMap<String, T> animals;
    private AviarySize size;

    public Aviary() {
        this.animals = new HashMap<>();
    }

    public void addAnimal(T animal) {
        if (animal.getAviarySize() == size) {
            System.out.println("Required aviary size doesn't match aviary size.");
        } else {
            animals.put(animal.getUniqueName(), animal);
        }
    }

    public T removeAnimal(Animals animal, String uniqueIDName) {
        T removedAnimal = animals.remove(uniqueIDName);
        if (removedAnimal == null) {
            System.out.println("Animal  with ID \"" + uniqueIDName + "\" is not found in the herbivoreAviary.");
        } else {
            System.out.println(animal.getClass().getSimpleName() + " with ID \"" + uniqueIDName + "\" has been removed from the aviary.");
        }
        return removedAnimal;
    }

    public T getAnimal(String uniqueIDName) {
        return animals.get(uniqueIDName);
    }

    public Map<String, T> getAllAnimals() {
        return animals;
    }
}
