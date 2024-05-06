package animals;

import food.Food;

public abstract class Animals {

    private int hungerLevel;
    private int thirst;

    private static final int MIN_VALUE = 0;
    private static final int MAX_VALUE = 100;

    public Animals(int hungerLevel, int thirst) {
        this.hungerLevel = hungerLevel;
        this.thirst = thirst;
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

    public abstract void eat(Food food);
}
