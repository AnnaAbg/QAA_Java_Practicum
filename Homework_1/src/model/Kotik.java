package model;

public class Kotik {

    private String name;
    private int weight;
    private int hungerLevel;
    private String meow;
    private static int catCount = 0;

    public Kotik(String name, int weight, String meow) {
        this.name = name;
        this.weight = weight;
        this.meow = meow;
        this.hungerLevel = 7;
        catCount++;
    }

    public Kotik() {
        this("", 0, "");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getMeow() {
        return meow;
    }

    public void setMeow(String meow) {
        this.meow = meow;
    }

    public int getHungerLevel() {
        return hungerLevel;
    }

    public void setHungerLevel(int hungerLevel) {
        this.hungerLevel = hungerLevel;
    }

    public static int getCatCount() {
        return catCount;
    }

    public static void setCatCount(int catCount) {
        Kotik.catCount = catCount;
    }

    public void play() {
        if (hungerLevel <= 0) {
            System.out.println(name + " is too hungry to play. Feed the kitty first!");
        } else {
            System.out.println("Playing with a ball... ");
        }
    }

    public void chaseMouse() {
        if (hungerLevel <= 0) {
            System.out.println(name + " is too hungry to chase a mouse. Feed the kitty first!");
        } else {
            System.out.println("Chasing a mouse...");
        }
    }

    public void sleep() {
        if (hungerLevel <= 0) {
            System.out.println(name + " is too hungry to sleep. Feed the kitty first!");
        } else {
            System.out.println("Sleeping...Zzz...");
        }
    }

    public void groom() {
        if (hungerLevel <= 0) {
            System.out.println(name + " is too hungry to groom itself. Feed the kitty first!");
        } else {
            System.out.println("Grooming itself...");
        }
    }

    public void eat(int foodAmount) {
        hungerLevel += foodAmount;
        System.out.println(name + " has eaten " + foodAmount + " units of food. ");
    }

    public void eat(String foodName, int foodAmount) {
        hungerLevel += foodAmount;
        System.out.println(name + " has eaten " + foodAmount + " units of " + foodName + ".");
    }

    public void eat() {
        eat("fish", 3);
    }

    public void liveAnotherDay() {
        int numberOfActions = 5;

        for (int i = 0; i < 24; i++) {
            int randomBehavior = (int) (Math.random() * numberOfActions + 1);

            switch (randomBehavior) {
                case 1:
                    play();
                    break;
                case 2:
                    sleep();
                    break;
                case 3:
                    if (hungerLevel <= 0) {
                        System.out.println(name + " is too hungry to do anything! Feed it first!");
                    } else {
                        eat();
                    }
                    break;
                case 4:
                    chaseMouse();
                    break;
                case 5:
                    groom();
                    break;
            }
        }
    }
}
