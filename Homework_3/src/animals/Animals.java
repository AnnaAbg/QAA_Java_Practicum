package animals;

import food.Food;

public abstract class Animals {

    private String uniqueIDName;
    private AviarySize aviarySize;
    private int hungerLevel;
    private int thirst;

    private static final int MIN_VALUE = 0;
    private static final int MAX_VALUE = 100;

    public Animals(String uniqueIDName, AviarySize aviarySize, int hungerLevel, int thirst) {
        this.uniqueIDName = uniqueIDName;
        this.aviarySize = aviarySize;
        this.hungerLevel = hungerLevel;
        this.thirst = thirst;
    }

    public AviarySize getAviarySize() {
        return aviarySize;
    }

    public String getUniqueName() {
        return uniqueIDName;
    }

    public void setHungerLevel(int hungerLevel) {
        this.hungerLevel = hungerLevel;
    }

    public int getHungerLevel() {
        return hungerLevel;
    }

    public void decreaseHungerLevel(int value) {
        System.out.println(hungerLevel -= value);
    }

    public void increaseHungerLevel(Food food) {
        hungerLevel = validateValue(hungerLevel + food.getFoodValue());
    }

    public void setThirst(int thirst) {
        this.thirst = thirst;
    }

    public int getThirst() {
        return thirst;
    }

    public void decreaseThirst(int value) {
        System.out.println(thirst -= value);
    }

    public void increaseThirst(int value) {
        thirst = validateValue(thirst + value);
    }

    public void checkHungerLevel() {
        if (hungerLevel <= 0) {
            System.out.println("The animal is hungry! Feed it! ");
        } else if (isHungry() || hungerLevel <= MAX_VALUE) {
            System.out.println("The animal is full!");
        } else {
            System.out.println("The animal is neither full nor hungry");
        }
    }

    public boolean isHungry() {
        return hungerLevel > 0;
    }

    private int validateValue(int value) {
        return Math.max(MIN_VALUE, Math.min(MAX_VALUE, value));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animals animal = (Animals) o;
        return uniqueIDName.equals(animal.uniqueIDName);
    }

    @Override
    public int hashCode() {
        return uniqueIDName.hashCode();
    }

    public abstract void eat(Food food) throws WrongFoodException;
}
