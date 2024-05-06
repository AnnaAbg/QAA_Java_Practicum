import animals.*;
import animals.actions.Swim;
import food.*;

public class Zoo {

    public static void main(String[] args) {

        Worker worker = new Worker();

        Animals animal = new SalmonFish();
        animal = new Wolf();

        Deer deer = new Deer();
        Falcon falcon = new Falcon();
        Duck duck = new Duck();
        SalmonFish salmon = new SalmonFish();
        Horse horse = new Horse();
        Wolf wolf = new Wolf();

        Food leaves1 = new Leaves();

        Grass grass = new Grass();
        Leaves leaves = new Leaves();
        AquaticPlants aquaticPlants = new AquaticPlants();
        MeatFood meat = new MeatFood();
        FishFood fish = new FishFood();
        InsectsFood insects = new InsectsFood();


        /**
         * Deer
         */
        deer.checkHungerLevel();
        deer.eat(new Leaves());
        deer.eat(new MeatFood());

        deer.decreaseHungerLevel(15);
        deer.increaseHungerLevel(new Grass());
        System.out.println(deer.getHungerLevel());

        deer.increaseThirst(10);
        System.out.println("The thirst is " + deer.getThirst());

        deer.run();
        System.out.println("Deer makes sound: " + deer.voice());

        System.out.println("---------------------------------------------");


        /**
         * Duck
         */
        duck.checkHungerLevel();
        duck.eat(new Grass());
        duck.eat(new MeatFood());

        duck.increaseHungerLevel(new AquaticPlants());
        System.out.println(duck.getHungerLevel());

        duck.increaseThirst(15);
        System.out.println("The thirst is " + duck.getThirst());

        duck.run();
        System.out.println("Deer makes sound: " + duck.voice());

        System.out.println("---------------------------------------------");


        /**
         * Falcon
         */
        falcon.checkHungerLevel();
        falcon.eat(new Grass());
        falcon.eat(new AquaticPlants());
        falcon.eat(new FishFood());

        falcon.increaseHungerLevel(grass);
        System.out.println(falcon.getHungerLevel());

        falcon.decreaseThirst(25);
        falcon.increaseThirst(15);
        System.out.println("The thirst is " + falcon.getThirst());

        falcon.fly();
        System.out.println("Falcon makes sound: " + falcon.voice());

        System.out.println("---------------------------------------------");


        /**
         * Worker
         */
        System.out.println("-------------------");
        worker.feedTheAnimal(deer, new Grass());
        worker.feedTheAnimal(deer, new MeatFood());
        worker.feedTheAnimal(deer, leaves);

        worker.feedTheAnimal(duck, fish);
        worker.feedTheAnimal(duck, aquaticPlants);
        worker.feedTheAnimal(duck, meat);
//
        worker.feedTheAnimal(falcon, fish);
        worker.feedTheAnimal(falcon, meat);
        worker.feedTheAnimal(falcon, insects);
        worker.feedTheAnimal(falcon, leaves);

        worker.feedTheAnimal(horse, grass);
        worker.feedTheAnimal(horse, meat);
        worker.feedTheAnimal(horse, leaves);

        worker.feedTheAnimal(salmon, fish);
        worker.feedTheAnimal(salmon, meat);

        worker.feedTheAnimal(wolf, fish);
        worker.feedTheAnimal(wolf, meat);
        worker.feedTheAnimal(wolf, aquaticPlants);

        /**
         * getVoice
         */
        System.out.println(worker.getVoice(deer));
        System.out.println(worker.getVoice(duck));
        System.out.println(worker.getVoice(falcon));
        System.out.println(worker.getVoice(horse));
        System.out.println(worker.getVoice(wolf));

        System.out.println("---------------------------------------------");

        /**
         * Pond Animals
         */

        Swim[] pond = {duck, salmon};
        pond[0] = new Duck();
        pond[1] = new SalmonFish();

        for (int i = 0; i < pond.length; i++) {
            pond[i].swim();
        }
    }
}
