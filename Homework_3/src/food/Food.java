package food;

public abstract class Food implements FoodValue {

    @Override
    public int getFoodValue() {
        return (int) (Math.random() * 10) + 1;
    }
}
