package food;

import food.Grass;

public class Leaves extends Food {
    @Override
    public int getFoodValue() {
        return (int) (Math.random() * 10) + 1;
    }
}
