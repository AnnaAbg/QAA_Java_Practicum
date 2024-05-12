import animals.*;
import food.*;

import java.util.Map;

public class Zoo {

    public static void main(String[] args) {

        Worker worker = new Worker();

        /**
         * Instantiation of the aviary objects
         */

        Aviary<Herbivore> herbivoreAviary = new Aviary<>();
        Aviary<Carnivore> carnivoreAviary = new Aviary<>();


        /**
         * Instantiation of the objects representing various food
         */
        Grass grass = new Grass();
        Leaves leaves = new Leaves();
        AquaticPlants aquaticPlants = new AquaticPlants();
        MeatFood meat = new MeatFood();
        FishFood fish = new FishFood();
        InsectsFood insects = new InsectsFood();


        /**
         * Instantiation of the objects representing various animal species.
         */
        Deer deer = new Deer("Comet", AviarySize.MEDIUM);
        Duck duck = new Duck("Donald", AviarySize.SMALL);
        Horse horse = new Horse("Argo", AviarySize.LARGE);
        Falcon falcon = new Falcon("Blaze", AviarySize.SMALL);
        Wolf wolf = new Wolf("Kylo", AviarySize.MEDIUM);
        Whale whale = new Whale("Willy", AviarySize.EXTRA_LARGE);
        System.out.println("The animal type: " + whale.getClass().getSimpleName()
                + "\nThe name: " + whale.getUniqueName() + "\nThe aviary size: " + whale.getAviarySize());

        System.out.println("---------------------------------------");


        /**
         * Instantiation of the objects representing animals through abstract classes Herbivore and Carnivore
         */
//        Herbivore deer = new Deer("Comet", AviarySize.MEDIUM);
//        Herbivore duck = new Duck("Donald", AviarySize.SMALL);
//        Herbivore horse = new Horse("Argo", AviarySize.LARGE);

//        Carnivore falcon = new Falcon("Blaze", AviarySize.SMALL)
//        Carnivore wolf = new Wolf("Kylo", AviarySize.MEDIUM);
//        Carnivore whale = new Whale("Willy", AviarySize.EXTRA_LARGE);

        /**
         * Add herbivores to the herbivore aviary
         */
        herbivoreAviary.addAnimal(deer);
        herbivoreAviary.addAnimal(duck);
        herbivoreAviary.addAnimal(horse);

        /*
          Get the animal
         */
        Herbivore foundHorse = herbivoreAviary.getAnimal("Argo");
        System.out.println(foundHorse);

        System.out.println("---------------------------------------");

        /**
         * Add carnivores to the carnivore aviary
         */
        carnivoreAviary.addAnimal(falcon);
        carnivoreAviary.addAnimal(wolf);
        carnivoreAviary.addAnimal(whale);

        /*
          Get the animal
         */
        Carnivore foundWolf = carnivoreAviary.getAnimal("Kylo");
        System.out.println(foundWolf);

        System.out.println("---------------------------------------");


        /**
         * Get all the animals from the aviary (key = value)
         */
        Map<String, Herbivore> allHerbivores = herbivoreAviary.getAllAnimals();
        for (Map.Entry<String, Herbivore> entry : allHerbivores.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        System.out.println(allHerbivores);

        System.out.println("--------------------------------------");

        Map<String, Carnivore> allCarnivores = carnivoreAviary.getAllAnimals();
        for (Map.Entry<String, Carnivore> entry : allCarnivores.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        System.out.println(allCarnivores);

        System.out.println("--------------------------------------");

        /**
         * Remove animal species from the aviary
         */
        carnivoreAviary.removeAnimal(whale, "Willy");
        herbivoreAviary.removeAnimal(horse, "Argo");
        System.out.println("---------------------------------------");

        /**
         * Get animal by unique ID name
         */

        Herbivore retrievedDeer = herbivoreAviary.getAnimal(deer.getUniqueName());
        Carnivore retrievedWolf = carnivoreAviary.getAnimal(wolf.getUniqueName());

        System.out.println(retrievedDeer);
        System.out.println(retrievedWolf);

        System.out.println("---------------------------------------");


        /**
         * Get all the animals in the herbivore aviary
         */
        System.out.println("Herbivore Aviary:");
        for (Herbivore herbivore : herbivoreAviary.getAllAnimals().values()) {
            System.out.println(herbivore.getUniqueName());
        }

        /**
         * Get all the animals in the carnivore aviary
         */
        System.out.println("Carnivore Aviary:");
        for (Carnivore carnivore : carnivoreAviary.getAllAnimals().values()) {
            System.out.println(carnivore.getUniqueName());
        }
        System.out.println("---------------------------------------");


        /**
         * Herbivores Horse - method eat()
         */

        try {
            horse.eat(new Grass());
        } catch (WrongFoodException e) {
            System.out.println(e.getMessage());
        }

        try {
            horse.eat(new MeatFood());
        } catch (WrongFoodException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("-----------------------------------------");

        /**
         * Carnivore Wolf - method eat()
         */

        try {
            wolf.eat(leaves);
        } catch (WrongFoodException e) {
            System.out.println(e.getMessage());
        }

        try {
            wolf.eat(meat);
        } catch (WrongFoodException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("-----------------------------------------");


        /**
         * Worker (feedTheAnimal(),deer, falcon)
         */

        try {
            worker.feedTheAnimal(deer, meat);
        } catch (WrongFoodException e) {
            System.out.println(e.getMessage());
        }

        try {
            worker.feedTheAnimal(deer, grass);
        } catch (WrongFoodException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("------------------------------");

        try {
            worker.feedTheAnimal(falcon, fish);
        } catch (WrongFoodException e) {
            System.out.println(e.getMessage());
        }

        try {
            worker.feedTheAnimal(falcon, leaves);
        } catch (WrongFoodException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("---------------------------------------");
    }
}
