package animals;

import animals.aviarySizeEnum.AviarySize;

public abstract class Carnivore extends Animals {

    public Carnivore(String uniqueIDName, AviarySize aviarySize, int hungerLevel, int thirst) {
        super(uniqueIDName, aviarySize, hungerLevel, thirst);
    }
}
