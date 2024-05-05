package food;

public class Meat extends Food{

    @Override
    public int getFoodValue() {
        return (int) (Math.random() * 10) + 5;
    }
}
