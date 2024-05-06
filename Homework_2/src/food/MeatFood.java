package food;

public class MeatFood extends Food{

    @Override
    public int getFoodValue() {
        return (int) (Math.random() * 10) + 1;
    }
}
