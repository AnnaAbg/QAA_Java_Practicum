package animals;

import animals.actions.Swim;
import food.Food;
import food.Grass;
import food.Meat;

public class Zoo {

    public static void main(String[] args) {

        Worker worker = new Worker();

        Animals animal = new SalmonFish();
        animal = new Wolf();

        Food grass = new Grass();
        Food meat = new Meat();

        Deer deer = new Deer();
        Falcon falcon = new Falcon();
        Duck duck = new Duck();
        SalmonFish salmon = new SalmonFish();
        Horse horse = new Horse();
        Wolf wolf = new Wolf();

        /**
         * Deer
         */
        deer.checkHungerLevel();
        deer.eat(new Grass());
        deer.eat(new Meat());

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
        deer.eat(new Meat());

        duck.increaseHungerLevel(new Grass());
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
        falcon.eat(new Meat());

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
        worker.feedTheAnimal(deer, grass);
        worker.feedTheAnimal(deer, meat);

        worker.feedTheAnimal(duck, meat);
        worker.feedTheAnimal(duck, grass);

        worker.feedTheAnimal(falcon, grass);
        worker.feedTheAnimal(falcon, meat);

        worker.feedTheAnimal(horse, grass);
        worker.feedTheAnimal(horse, meat);

        worker.feedTheAnimal(salmon, grass);
        worker.feedTheAnimal(salmon, meat);

        worker.feedTheAnimal(wolf, grass);
        worker.feedTheAnimal(wolf, meat);

        System.out.println(worker.getVoice(deer));
        System.out.println(worker.getVoice(duck));
        System.out.println(worker.getVoice(falcon));
        System.out.println(worker.getVoice(horse));
        ;
        System.out.println(worker.getVoice(wolf));

        System.out.println("---------------------------------------------");

        /**
         * Pond Animals
         */

        Swim[] pondS = {duck, salmon};
        pondS[0] = new Duck();
        pondS[1] = new SalmonFish();

        for (int i = 0; i < pondS.length; i++) {
            pondS[i].swim();
        }
    }
}
