package animals;

public abstract class Herbivore extends Animals {

    public Herbivore(String uniqueIDName, AviarySize aviarySize, int hungerLevel, int thirst) {
        super(uniqueIDName, aviarySize, hungerLevel, thirst);
    }
}
